package org.esprim.tpfoyer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Foyer {
    @Id
    @GeneratedValue
    private Long idFoyer;
    private String nomFoyer;
    private Long capaciteFoyer;
}
