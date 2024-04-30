package hn.lenguajes.reposicion.util;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import hn.lenguajes.reposicion.Entities.Posiciones;
import hn.lenguajes.reposicion.Repositories.PosicionesRepositpory;

public class simulacionUtil {

    @Autowired
    private static PosicionesRepositpory posicionesRepositpory;

    public static int goles() {
        Random random = new Random();
        return random.nextInt(5);
    }


    public static double crearNoJugadores() {
        double rangoMinimo = 1.0;
        double rangoMaximo = 11.0;
        Random random = new Random();
        return rangoMinimo + (rangoMaximo - rangoMinimo) * random.nextDouble();
    }

    public static Posiciones obtenerPosicion(int codigoEquipo) {
        List<Posiciones> posiciones = (List<Posiciones>) posicionesRepositpory.findAll();
        Posiciones posicionBuscada = new Posiciones();
        
        for (Posiciones posicion : posiciones) {
            if (posicion.getCodigoEquipo().getCodigoEquipo() == codigoEquipo) {
                posicionBuscada = posicion;
            }
        }
        
        return posicionBuscada;
    }

    
}
