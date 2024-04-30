package hn.lenguajes.reposicion.Services.impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.lenguajes.reposicion.Entities.Equipos;
import hn.lenguajes.reposicion.Entities.Posiciones;
import hn.lenguajes.reposicion.Repositories.EquiposRepository;
import hn.lenguajes.reposicion.Repositories.PosicionesRepositpory;
import hn.lenguajes.reposicion.Services.SimulacionService;
import hn.lenguajes.reposicion.util.simulacionUtil;
@Service
public class SimulacionServiceImpl implements SimulacionService{

    @Autowired
    private EquiposRepository equiposRepository;

    @Autowired
    private PosicionesRepositpory posicionesRepositpory;
    @Override
    public String simulacionDePartidos() {
        List<Equipos> equipos = (List<Equipos>) equiposRepository.findAll();
        if (equipos.size() < 6) {
            for (int i = 0; i < (6 - equipos.size()); i++) {
                Equipos nvoequipo = new Equipos();

                nvoequipo.setNombre(crearNombre());
                nvoequipo.setAtaque(simulacionUtil.crearNoJugadores());
                nvoequipo.setDefensa(simulacionUtil.crearNoJugadores());

                this.equiposRepository.save(nvoequipo);
            }
        }
        Equipos equiposA = equipos.get(0);
        Equipos equiposB = equipos.get(0);
        if (equiposA == equiposB) {
            return "No se puede enfrentar el mismo equipo";
        }else {
            for (int i = 0; i < equipos.size(); i++) {
                Equipos equipoA = equipos.get(i);
    
                for (int j = i + 1; j < equipos.size(); j++) {
                    Equipos equipoB = equipos.get(j);
    
                    int golesEquipoA = simulacionUtil.goles();
                    int golesEquipoB = simulacionUtil.goles();
                    actualizarPosiciones(equipoA, equipoB, golesEquipoA, golesEquipoB);
                }
            }
        }
       
        return "Simulacion hecha con exito";
    }

    private void actualizarPosiciones(Equipos equipoA, Equipos equipoB, int golesEquipoA, int golesEquipoB) {
  
        Posiciones posicionEquipoA = simulacionUtil.obtenerPosicion(equipoA.getCodigoEquipo());
        Posiciones posicionEquipoB = simulacionUtil.obtenerPosicion(equipoB.getCodigoEquipo());

        Posiciones nvoPosicion = new Posiciones();
        if(posicionEquipoA==null){
            nvoPosicion.setCodigoEquipo(equipoA);
            nvoPosicion.setEmpates(0);
            nvoPosicion.setGanados(0);
            nvoPosicion.setGolesContra(0);
            nvoPosicion.setGolesFavor(0);
            nvoPosicion.setPuntos(0);

            this.posicionesRepositpory.save(nvoPosicion);

        }else if(posicionEquipoB==null){
            nvoPosicion.setCodigoEquipo(equipoB);
            nvoPosicion.setEmpates(0);
            nvoPosicion.setGanados(0);
            nvoPosicion.setGolesContra(0);
            nvoPosicion.setGolesFavor(0);
            nvoPosicion.setPuntos(0);

            this.posicionesRepositpory.save(nvoPosicion);
        }

        posicionEquipoA = simulacionUtil.obtenerPosicion(equipoA.getCodigoEquipo());
        posicionEquipoB = simulacionUtil.obtenerPosicion(equipoB.getCodigoEquipo());
        if (golesEquipoA > golesEquipoB) {
            posicionEquipoA.setPuntos(posicionEquipoA.getPuntos() + 3);
            posicionEquipoA.setGolesFavor(posicionEquipoA.getGolesFavor() + golesEquipoA);
            posicionEquipoA.setGolesContra(posicionEquipoA.getGolesContra() + golesEquipoB);
            posicionEquipoA.setGanados(posicionEquipoA.getGanados() + 1);

            posicionEquipoB.setGolesFavor(posicionEquipoB.getGolesFavor() + golesEquipoB);
            posicionEquipoB.setGolesContra(posicionEquipoB.getGolesContra() + golesEquipoA);
            posicionEquipoB.setPerdidos(posicionEquipoB.getPerdidos() + 1);
        } else if (golesEquipoA < golesEquipoB) {

            posicionEquipoB.setPuntos(posicionEquipoB.getPuntos() + 3);
            posicionEquipoB.setGolesFavor(posicionEquipoB.getGolesFavor() + golesEquipoB);
            posicionEquipoB.setGolesContra(posicionEquipoB.getGolesContra() + golesEquipoA);
            posicionEquipoB.setGanados(posicionEquipoB.getGanados() + 1);

            posicionEquipoA.setGolesFavor(posicionEquipoA.getGolesFavor() + golesEquipoA);
            posicionEquipoA.setGolesContra(posicionEquipoA.getGolesContra() + golesEquipoB);
            posicionEquipoA.setPerdidos(posicionEquipoA.getPerdidos() + 1);

        } 
    } 
   
    private static final List<String> equipos = List.of(
        "Real Madrid", "Bayern", "Barcelona", "Arsenal", "AJAX", "Olimpia", "Motagua");

    public static String crearNombre() {
        Random random = new Random();
        Object equipos;
        int indiceAleatorio = random.nextInt(equipos.size());
        return equipos.get(indiceAleatorio);
    }
    
}
