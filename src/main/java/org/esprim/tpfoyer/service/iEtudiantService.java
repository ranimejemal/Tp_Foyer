package org.esprim.tpfoyer.service;

import org.esprim.tpfoyer.entity.Etudiant;

import java.util.List;

public interface iEtudiantService {
    List<Etudiant> retrieveAllEtudiants();
    Etudiant retrieveEtudiant(Long etudiantId);
    Etudiant addEtudiant(Etudiant e);
    void removeEtudiant(Long etudiantId);
    Etudiant modifyEtudiant(Etudiant etudiant);
}
