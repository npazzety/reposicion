package hn.lenguajes.reposicion.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.lenguajes.reposicion.Services.impl.SimulacionServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/simulacion")
public class SimulacionController {

    @Autowired
    private SimulacionServiceImpl simulacionServiceImpl;

    @GetMapping("/simular")
    public String simular(@RequestParam String param) {
        return this.simulacionServiceImpl.simulacionDePartidos();
    }
    
    
}
