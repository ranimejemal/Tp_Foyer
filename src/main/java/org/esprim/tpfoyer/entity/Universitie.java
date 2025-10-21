package org.esprim.tpfoyer.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Universitie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUniversitie;
    private String nomUniversitie;
    private String adresse;

    @OneToOne
    private Foyer foyer;

}
