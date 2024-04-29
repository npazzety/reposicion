package hn.lenguajes.reposicion.Services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.lenguajes.reposicion.Entities.Equipos;
import hn.lenguajes.reposicion.Repositories.EquiposRepository;
import hn.lenguajes.reposicion.Services.EquiposService;
@Service
public class EquiposServiceImpl implements EquiposService{

    @Autowired
    private EquiposRepository equiposRepository;

    @Override
    public Equipos crearEquipos(Equipos equipo) {

        Equipos nvEquipo = new Equipos();
        nvEquipo.setNombre(equipo.getNombre());
        nvEquipo.setAtaque(equipo.getAtaque());
        nvEquipo.setDefensa(equipo.getDefensa());
        this.equiposRepository.save(nvEquipo);
        return this.equiposRepository.save(nvEquipo);
    }
   
    @Override
    public String eliminarEquipo(int codigoEquipo) {
        Equipos equipoEliminar = this.equiposRepository.findById(codigoEquipo).get();
        if(equipoEliminar!=null){
            this.equiposRepository.delete(equipoEliminar);
            return "El equipo ha sido eliminado";
        }
        return "No se pudo eliminar el equipo";
    }

    @Override
    public Equipos buscarEquipo(int codigoEquipo) {
        return this.equiposRepository.findById(codigoEquipo).get();
    }
}
