package hn.lenguajes.reposicion.Services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.lenguajes.reposicion.Entities.Posiciones;
import hn.lenguajes.reposicion.Repositories.PosicionesRepositpory;
import hn.lenguajes.reposicion.Services.PosicionesService;

@Service
public class PosicionesServiceImpl implements PosicionesService{

    @Autowired
    private PosicionesRepositpory posicionesRepositpory;

    @Override
    public List<Posiciones> obtenerTodaLaTabla() {
        return (List<Posiciones>) this.posicionesRepositpory.findAll();
    }
    
}
