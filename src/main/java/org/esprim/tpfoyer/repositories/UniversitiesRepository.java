package org.esprim.tpfoyer.repositories;

import org.esprim.tpfoyer.entity.Universitie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversitiesRepository extends JpaRepository<Universitie, Long> {
}
