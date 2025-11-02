package org.esprim.tpfoyer.service;

import org.esprim.tpfoyer.entity.Universitie;

import java.util.List;

public interface iUniversitiesService {
    List<Universitie> retrieveAllUniversites();
    Universitie retrieveUniversite(Long universiteId);
    Universitie addUniversite(Universitie u);
    void removeUniversite(Long universiteId);
    Universitie modifyUniversite(Universitie universite);
}
