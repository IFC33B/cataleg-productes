package ifc33b.dwesc.cataleg_productes.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifc33b.dwesc.cataleg_productes.dto.ProducteResponse;
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
}
