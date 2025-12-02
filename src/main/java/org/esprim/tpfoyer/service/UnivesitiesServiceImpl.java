package org.esprim.tpfoyer.service;

import lombok.AllArgsConstructor;
import org.esprim.tpfoyer.entity.Foyer;
import org.esprim.tpfoyer.entity.Universitie;
import org.esprim.tpfoyer.repositories.FoyerRepository;
import org.esprim.tpfoyer.repositories.UniversitiesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UnivesitiesServiceImpl implements iUniversitiesService{

    UniversitiesRepository universitiesRepository;
    FoyerRepository foyerRepository;

    @Override
    public List<Universitie> retrieveAllUniversites() {
        return universitiesRepository.findAll();
    }

    @Override
    public Universitie retrieveUniversite(Long universiteId) {
        return universitiesRepository.findById(universiteId).get();
    }

    @Override
    public Universitie addUniversite(Universitie u) {
        return universitiesRepository.save(u);
    }

    @Override
    public void removeUniversite(Long universiteId) {
        universitiesRepository.deleteById(universiteId);
    }

    @Override
    public Universitie modifyUniversite(Universitie universite) {
        return universitiesRepository.save(universite);
    }


    @Override
    public Universitie affecterFoyerAUniversite(Long idFoyer, String nomUniversite) {
        Foyer foyer = foyerRepository.findById(idFoyer).orElseThrow(() -> new RuntimeException("Foyer introuvable avec l'ID : " + idFoyer));
        Universitie universitie = (Universitie) universitiesRepository.findByNomUniversitie(nomUniversite).orElseThrow(() -> new RuntimeException("Universitie introuvable avec le nom :" + " " + nomUniversite));
        //verifier si l'association existe deja
        if (foyer.getUniversitie() != null || universitie.getFoyer() != null) {
            throw new RuntimeException("L'association existe deja pour ce foyer : " + " ou cette universitie.");
        }
        //affectation du foyer a luni
        universitie.setFoyer(foyer);
        //mettre a jour lz cote inverse
        foyer.setUniversitie(universitie);
        //sauvegarder les changement
        universitiesRepository.save(universitie);
        foyerRepository.save(foyer);
        return universitie;

    }

    @Override
    public Universitie desaffecterFoyerAUniversite(Long idUniversitie) {
        Universitie universitie = universitiesRepository.findById(idUniversitie)
                .orElseThrow(() -> new RuntimeException("Université n'existe pas : " + idUniversitie));


        if (universitie.getFoyer() == null) {
            throw new RuntimeException("Cette université n'a aucun foyer affecté.");
        }
        Foyer foyer = universitie.getFoyer();

        universitie.setFoyer(null);
        foyer.setUniversitie(null);

        universitiesRepository.save(universitie);
        foyerRepository.save(foyer);

        return universitie;

    }




}
