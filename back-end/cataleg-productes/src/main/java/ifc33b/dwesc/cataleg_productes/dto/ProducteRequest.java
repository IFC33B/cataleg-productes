package ifc33b.dwesc.cataleg_productes.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class ProducteRequest {
    // Atributos
    @NotBlank(message = "Se requiere nombre del producto")
    private String nom;

    @NotNull(message = "Se requiere un precio para el producto")
    @Positive(message = "El precio debe ser positivo")
    private Double preu;

    private String imatgeUrl;

    @NotNull(message = "Se requiere un stock del producto")
    @PositiveOrZero(message = "El stock tiene que ser positivo o 0")
    private Integer stock;

    // Constructor
    public ProducteRequest(String nom, Double preu, String imatgeUrl, Integer stock) {
        this.setNom(nom);
        this.setPreu(preu);
        this.setImatgeUrl(imatgeUrl);
        this.setStock(stock);
    }
}
