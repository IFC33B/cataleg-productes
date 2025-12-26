package ifc33b.dwesc.cataleg_productes.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifc33b.dwesc.cataleg_productes.dto.ProducteRequest;
import ifc33b.dwesc.cataleg_productes.dto.ProducteResponse;
import ifc33b.dwesc.cataleg_productes.model.Producte;
import ifc33b.dwesc.cataleg_productes.repository.ProducteRepository;

@Service
public class CatalegService {
    @Autowired
    ProducteRepository producteRepository;

    // Devolver todos los productos
    public List<ProducteResponse> getAllProductes() {
        return producteRepository.findAll().stream()
                .map(ProducteResponse::new)
                .collect(Collectors.toList());
    }

    public List<ProducteResponse> getProducteBetweenPrices(Double minPreu, Double maxPreu) {
        return producteRepository.filtrarPerPreu(minPreu, maxPreu).stream()
                .map(ProducteResponse::new)
                .collect(Collectors.toList());
    }

    // Crear un producto
    public ProducteResponse createProducte(ProducteRequest request) {
        Producte producte = new Producte(request.getNom(), request.getPreu(), request.getImatgeUrl(),
                request.getStock());
        producteRepository.save(producte);
        return new ProducteResponse(producte);
    }
}
