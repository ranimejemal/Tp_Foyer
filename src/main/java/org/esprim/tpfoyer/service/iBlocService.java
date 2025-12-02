package org.esprim.tpfoyer.service;

import org.esprim.tpfoyer.entity.Bloc;
import org.esprim.tpfoyer.entity.Chambre;

import java.util.List;

public interface iBlocService {
    public List<Bloc> retrieveAllBloc();
    public Bloc retrievebloc(Long blocId);
    public Bloc addBloc(Bloc b);
    public void removeBloc(Long blocId);
    public Bloc modifyBloc(Bloc bloc);
    public Bloc affecterChambresABloc(List<Long>numChambres, Long idBloc);
}
