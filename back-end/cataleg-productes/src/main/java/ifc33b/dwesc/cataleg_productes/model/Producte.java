package ifc33b.dwesc.cataleg_productes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Entity
@Data
@Table(name = "producte")
public class Producte {
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Se requiere nombre del producto")
    private String nom;

    @Column(nullable = false)
    @NotNull(message = "Se requiere un precio para el producto")
    @Positive(message = "El precio debe ser positivo")
    private Double preu;

    private String imatgeUrl;

    @Column(nullable = false)
    @NotNull(message = "Se requiere un stock del producto")
    @PositiveOrZero(message = "El stock tiene que ser positivo o 0")
    private Integer stock;

    // Constructor
    public Producte() {}

    public Producte(String nom, Double preu, String imatgeUrl, Integer stock) {
        this.setNom(nom);
        this.setPreu(preu);
        this.setImatgeUrl(imatgeUrl);
        this.setStock(stock);
    }
}
