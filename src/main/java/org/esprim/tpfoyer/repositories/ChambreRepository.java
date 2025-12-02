package org.esprim.tpfoyer.repositories;

import org.esprim.tpfoyer.entity.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository

public interface ChambreRepository extends JpaRepository <Chambre, Long> {
    List<Chambre> findAllByNumeroChambreIn(Collection<Long> numeroChambres);

}
