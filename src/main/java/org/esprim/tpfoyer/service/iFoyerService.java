package org.esprim.tpfoyer.service;

import org.esprim.tpfoyer.entity.Foyer;

import java.util.List;

public interface iFoyerService {
    List<Foyer> retrieveAllFoyers();
    Foyer retrieveFoyer(Long foyerId);
    Foyer addFoyer(Foyer f);
    void removeFoyer(Long foyerId);
    Foyer modifyFoyer(Foyer foyer);
}
