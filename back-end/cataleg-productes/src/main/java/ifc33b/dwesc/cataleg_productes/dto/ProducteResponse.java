package ifc33b.dwesc.cataleg_productes.dto;

import ifc33b.dwesc.cataleg_productes.model.Producte;
import lombok.Data;

@Data
public class ProducteResponse {
    // Atributos
    private Long id;
    private String nom;
    private float preu;
    private String imatgeUrl;
    private int stock;

    // Constructor
    public ProducteResponse(Producte producte) {
        this.setId(producte.getId());
        this.setNom(producte.getNom());
        this.setPreu(producte.getPreu());
        this.setImatgeUrl(producte.getImatgeUrl());
        this.setStock(producte.getStock());
    }
}
