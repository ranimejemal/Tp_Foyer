package org.esprim.tpfoyer.service;

import lombok.AllArgsConstructor;
import org.esprim.tpfoyer.entity.Universitie;
import org.esprim.tpfoyer.repositories.UniversitiesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UnivesitiesServiceImpl implements iUniversitiesService{

    UniversitiesRepository universitiesRepository;

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
}
