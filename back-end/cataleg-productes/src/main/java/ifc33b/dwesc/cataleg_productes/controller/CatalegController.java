package ifc33b.dwesc.cataleg_productes.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/productes")
public class CatalegController {

    @GetMapping() // Devuelve todos los productes
    public int getAllProductes() {
        return 0;
    }
    
    @GetMapping() // Devolver un producte entre 2 precios
    public int getProducteBetweenPrices() {
        return 0;
    }
    
    @PostMapping() // Añadir un producte
    public int createProducte(@RequestBody String entity) { 
        return 0;
    }
}
