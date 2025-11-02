package org.esprim.tpfoyer.service;

import lombok.AllArgsConstructor;
import org.esprim.tpfoyer.entity.Bloc;
import org.esprim.tpfoyer.repositories.BlocRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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


}
