package org.esprim.tpfoyer.service;

import org.esprim.tpfoyer.entity.Chambre;

import java.util.List;

public interface iChambreService {
    public List<Chambre> retrieveAllChambres();
    public Chambre retrieveChambre(Long chambreId);
    public Chambre addChambre(Chambre c);
    public void removeChambre(Long chambreId);
    public Chambre modifyChambre(Chambre chambre);
    List<Chambre> getChambresParNomUniversitie(String nomUniversitie);
}
