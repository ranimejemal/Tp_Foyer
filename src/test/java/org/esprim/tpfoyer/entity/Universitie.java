package org.esprim.tpfoyer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Universitie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUniversitie;
    private String nomUniversitie;
    private String adresse;
}
