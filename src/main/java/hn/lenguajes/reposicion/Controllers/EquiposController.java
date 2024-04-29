package hn.lenguajes.reposicion.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.lenguajes.reposicion.Entities.Equipos;
import hn.lenguajes.reposicion.Services.impl.EquiposServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/api/equipos")
public class EquiposController {

    @Autowired
    private EquiposServiceImpl equiposServiceImpl;
    
    @PostMapping("/crear")
    public Equipos crearEquipo(@RequestBody Equipos equipo) {
        return this.equiposServiceImpl.crearEquipos(equipo);
    }

    @PutMapping("eliminar/{codigoEquipo}")
    public String elimnarEquipo(@PathVariable int codigoEquipo, @RequestBody String entity) {        
        return this.equiposServiceImpl.eliminarEquipo(codigoEquipo);
    }

    @GetMapping("/buscarEquipo/{codigoEquipo}")
    public Equipos buscarEquipo(@PathVariable int codigoEquipo) {
        return this.equiposServiceImpl.buscarEquipo(codigoEquipo);
    }
    
    
}
