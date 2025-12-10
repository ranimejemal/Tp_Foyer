package org.esprim.tpfoyer.service;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.esprim.tpfoyer.entity.Chambre;
import org.esprim.tpfoyer.repositories.ChambreRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@AllArgsConstructor
public class ChambreServiceImpl implements iChambreService {

    ChambreRepository chambreRepository;
    @Override
    public List<Chambre> retrieveAllChambres() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre retrieveChambre(Long chambreId) {
        return chambreRepository.findById(chambreId).get();
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public void removeChambre(Long chambreId) {
        chambreRepository.deleteById(chambreId);
    }

    @Override
    public Chambre modifyChambre(Chambre chambre) {
        return chambreRepository.save(chambre) ;
    }

    @Override
    public List<Chambre> getChambresParNomUniversitie(String nomUniversitie) {
        return List.of();
    }

    @Scheduled(cron = "0/15 * * * * *")
    public void pourcentageChambreParTypeChambre(){
        List<Chambre> chambres = chambreRepository.findAll();
        int totalChambres = chambres.size();
        log.info("Total chambres {}",totalChambres);
        if (totalChambres>0){
            Map<String,Integer> countByType = new HashMap<>();
            for(Chambre chambre : chambres){
                String type= String.valueOf(chambre.getTypeC());
                countByType.put(type,countByType.getOrDefault(type,0));
            }
        }
    }
    
}
