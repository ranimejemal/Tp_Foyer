package org.esprim.tpfoyer.service;

import lombok.AllArgsConstructor;
import org.esprim.tpfoyer.entity.Bloc;
import org.esprim.tpfoyer.entity.Foyer;
import org.esprim.tpfoyer.entity.Universitie;
import org.esprim.tpfoyer.repositories.ChambreRepository;
import org.esprim.tpfoyer.repositories.FoyerRepository;
import org.esprim.tpfoyer.repositories.UniversitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FoyerServiceImpl implements iFoyerService {

    UniversitiesRepository universitieRepository;


    FoyerRepository foyerRepository;

    @Override
    public List<Foyer> retrieveAllFoyers() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer retrieveFoyer(Long foyerId) {
        return foyerRepository.findById(foyerId).orElse(null);
    }

    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public void removeFoyer(Long foyerId) {
        foyerRepository.deleteById(foyerId);
    }

    @Override
    public Foyer modifyFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public Foyer ajouterFoyerEtAffecterAUniversitie(Foyer f, Long idUniversitie) {
        return null;
    }


}
