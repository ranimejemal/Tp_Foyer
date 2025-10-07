package org.esprim.tpfoyer.repositories;

import org.esprim.tpfoyer.entity.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ChambreRepository extends JpaRepository <Chambre, Long> {
}
