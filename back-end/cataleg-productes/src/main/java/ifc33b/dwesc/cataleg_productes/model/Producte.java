package ifc33b.dwesc.cataleg_productes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "Se requiere precio del producto")
    private float preu;

    @Column(nullable = false)
    @NotBlank(message = "Se requiere una imagen del producto")
    private String imatgeUrl;

    @Column(nullable = false)
    @NotBlank(message = "Se requiere stock del producto")
    private int stock;

    // Constructor
    public Producte() {}

    public Producte(String nom, float preu, String imatgeUrl, int stock) {
        this.setNom(nom);
        this.setPreu(preu);
        this.setImatgeUrl(imatgeUrl);
        this.setStock(stock);
    }
}
