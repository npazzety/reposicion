package hn.lenguajes.reposicion.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.lenguajes.reposicion.Entities.Posiciones;
import hn.lenguajes.reposicion.Services.impl.PosicionesServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/posiciones")
public class PosicionesController {

    @Autowired
    private PosicionesServiceImpl posicionesServiceImpl;

    @GetMapping("tablaposiciones")
    public List<Posiciones> obtenerLaTablaPosiciones() {
        return this.posicionesServiceImpl.obtenerTodaLaTabla();
    }
    
    
}
