package org.esprim.tpfoyer.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;


@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Foyer implements Serializable {
    @Id
    @GeneratedValue
    private Long idFoyer;
    private String nomFoyer;
    private Long capaciteFoyer;

    @OneToOne(mappedBy = "foyer")
    private Universitie universitie;

    @OneToMany(mappedBy = "foyer" , cascade = CascadeType.ALL)
    private List<Bloc> blocs;


}
