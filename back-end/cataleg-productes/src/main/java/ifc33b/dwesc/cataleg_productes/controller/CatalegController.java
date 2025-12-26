package ifc33b.dwesc.cataleg_productes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ifc33b.dwesc.cataleg_productes.dto.ProducteRequest;
import ifc33b.dwesc.cataleg_productes.dto.ProducteResponse;
import ifc33b.dwesc.cataleg_productes.service.CatalegService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/productes")
public class CatalegController {
    @Autowired
    private CatalegService catalegService;
    
    @GetMapping() // Devolver los productos, con posibilidad de filtro de precios
    public ResponseEntity<List<ProducteResponse>> getAllProductes(@RequestParam(required = false) Double minPreu, Double maxPreu) {
        // Service
        List<ProducteResponse> response = catalegService.getAllProductes(maxPreu, minPreu);

        // HTTP Response
        return ResponseEntity.ok(response);
        
    }
    
    @PostMapping() // Añadir un producte
    public ResponseEntity<ProducteResponse> createProducte(@Valid @RequestBody ProducteRequest request) { 
        // Service
        ProducteResponse response = catalegService.createProducte(request);

        // HTTP Response
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
