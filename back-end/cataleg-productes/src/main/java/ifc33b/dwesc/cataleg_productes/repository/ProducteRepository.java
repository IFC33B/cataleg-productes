package ifc33b.dwesc.cataleg_productes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ifc33b.dwesc.cataleg_productes.model.Producte;

@Repository
public interface ProducteRepository extends JpaRepository<Producte, Long> {}
