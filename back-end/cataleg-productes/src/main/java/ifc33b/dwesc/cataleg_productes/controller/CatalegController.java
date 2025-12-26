package ifc33b.dwesc.cataleg_productes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ifc33b.dwesc.cataleg_productes.dto.ProducteResponse;
import ifc33b.dwesc.cataleg_productes.service.CatalegService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/productes")
public class CatalegController {
    @Autowired
    private CatalegService catalegService;

    @GetMapping() // Devuelve todos los productes
    public ResponseEntity<List<ProducteResponse>> getAllProductes() {
        // Service
        List<ProducteResponse> response = catalegService.getAllProductes();

        // HTTP Response
        return ResponseEntity.ok(response);
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
