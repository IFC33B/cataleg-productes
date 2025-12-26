package ifc33b.dwesc.cataleg_productes.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProducteRequest {
    // Atributos
    @Column(nullable = false)
    @NotBlank(message = "Se requiere nombre del producto")
    private String nom;

    @Column(nullable = false)
    @NotBlank(message = "Se requiere precio del producto")
    private float preu;

    @Column(nullable = false)
    @NotBlank(message = "Se requiere una imagen del producto")
    private String imatgeUrl;

    @Column(nullable = false)
    @NotBlank(message = "Se requiere stock del producto")
    private int stock;

    // Constructor
    public ProducteRequest(String nom, float preu, String imatgeUrl, int stock) {
        this.setNom(nom);
        this.setPreu(preu);
        this.setImatgeUrl(imatgeUrl);
        this.setStock(stock);
    }
}
