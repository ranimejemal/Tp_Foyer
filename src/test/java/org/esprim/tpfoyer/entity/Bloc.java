package org.esprim.tpfoyer.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Bloc {

    @Id
    @GeneratedValue
    private Long idBloc;
    private String nomBloc;
    private Long capaciteBloc;
}
