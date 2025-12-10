package org.esprim.tpfoyer.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.esprim.tpfoyer.entity.Bloc;
import org.esprim.tpfoyer.entity.Chambre;
import org.esprim.tpfoyer.repositories.BlocRepository;
import org.esprim.tpfoyer.repositories.ChambreRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service
@AllArgsConstructor

public class blocServiceImpl implements iBlocService {
    BlocRepository blocRepository;
    @Override
    public List<Bloc> retrieveAllBloc() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc retrievebloc(Long blocId) {
        return blocRepository.findById(blocId).get();
    }


    @Override
    public Bloc addBloc(Bloc b) {
        return blocRepository.save(b);
    }

    @Override
    public void removeBloc(Long chambreId) {
        blocRepository.deleteById(chambreId);
    }

    @Override
    public Bloc modifyBloc(Bloc bloc) {
        return blocRepository.save(bloc) ;
    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambres, Long idBloc) {
        ChambreRepository chambreRepository = null;
        // 1. Récupérer le bloc et verifier est ce que jai un bloc avec cet id
        Bloc bloc = blocRepository.findById(idBloc)
                .orElseThrow(() -> new RuntimeException("Bloc n'existe pas : " + idBloc));

        // 2. Charger les chambres correspondantes and
        List<Chambre> chambres = chambreRepository.findAllByNumeroChambreIn(numChambres);

        if (chambres.size() != numChambres.size()) {
            throw new RuntimeException("Aucune chambre trouvée pour les numéros fournis !");
        }

        // 3. Vérifier chambres une par une and
        for (Chambre chambre : chambres) {

            // Vérifier si la chambre est déjà affectée à un bloc and Is the room already linked to another bloc that is NOT the bloc we want to assign now?
            if (chambre.getBloc() != null && chambre.getBloc().getIdBloc() != idBloc) {

                throw new RuntimeException(
                        "La chambre " + chambre.getNumeroChambre() +
                                " est déjà affectée au bloc : " + chambre.getBloc().getNomBloc()
                );

            }
        }

            // Affecter la chambre au bloc
            for (Chambre chambre : chambres) {
                chambre.setBloc(bloc);
            }
            // Ajouter la chambre côté bloc si ce n'est pas déjà fait
            if(bloc.getIdBloc()==null)
                bloc.setChambres(new ArrayList<Chambre>());

            bloc.getChambres().addAll(chambres);
        // 4. Sauvegarder modifications
        chambreRepository.saveAll(chambres);
        blocRepository.save(bloc);

        return bloc;
    }

    @Scheduled(cron = "0 * * * * *")
    public void listeChambreParBloc() {

        List<Bloc> blocs = blocRepository.findAll();

        if (!blocs.isEmpty()) {

            for (Bloc bloc : blocs) {

                // Bloc header
                log.info("Bloc => " + bloc.getNomBloc() + " ayant une capacité " + bloc.getCapaciteBloc());
                log.info("La liste des chambres pour ce bloc :");

                // No rooms in this bloc
                if (bloc.getChambres() == null || bloc.getChambres().isEmpty()) {
                    log.info("Pas de chambre disponible dans ce bloc");
                    log.info("**********************");
                    continue;
                }

                // List rooms
                for (Chambre chambre : bloc.getChambres()) {
                    log.info("NumChambre: " + chambre.getNumeroChambre()
                            + " | type: " + chambre.getTypeC());
                }

                log.info("**********************");
            }

        } else {
            log.info("Aucun bloc enregistré");
        }
    }

}