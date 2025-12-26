package ifc33b.dwesc.cataleg_productes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ifc33b.dwesc.cataleg_productes.model.Producte;

@Repository
public interface ProducteRepository extends JpaRepository<Producte, Long> {
    @Query("SELECT p FROM Producte p WHERE (:minPreu IS NULL OR p.preu >= :minPreu) AND (:maxPreu IS NULL OR p.preu <= :maxPreu)")
    List<Producte> filtrarPerPreu(@Param("minPreu") Double minPreu, @Param("maxPreu") Double maxPreu);
}
