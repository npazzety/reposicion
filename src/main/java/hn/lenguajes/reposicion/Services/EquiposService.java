package hn.lenguajes.reposicion.Services;

import hn.lenguajes.reposicion.Entities.Equipos;

public interface EquiposService {
    
    public Equipos crearEquipos(Equipos equipo);

    public String eliminarEquipo(int codigoEquipo);

    public Equipos buscarEquipo(int codigoEquipo);
}
