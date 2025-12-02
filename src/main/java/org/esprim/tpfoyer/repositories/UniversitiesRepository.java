package org.esprim.tpfoyer.repositories;

import org.esprim.tpfoyer.entity.Universitie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UniversitiesRepository extends JpaRepository<Universitie, Long> {
    Optional<Object> findByNomUniversitie(String nomUniversite);
}
