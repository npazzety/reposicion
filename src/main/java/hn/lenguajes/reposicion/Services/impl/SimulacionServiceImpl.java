package hn.lenguajes.reposicion.Services.impl;

import org.springframework.stereotype.Service;

import hn.lenguajes.reposicion.Services.SimulacionService;
@Service
public class SimulacionServiceImpl implements SimulacionService{

    @Override
    public String simulacionDePartidos() {
      return "Partido simulado con exito";
    }

    
}
