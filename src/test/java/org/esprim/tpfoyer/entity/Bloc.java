package org.esprim.tpfoyer.entity;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Bloc implements Serializable {

    @Id
    @GeneratedValue
    private Long idBloc;
    private String nomBloc;
    private Long capaciteBloc;

    @OneToMany(mappedBy = "bloc",cascade = CascadeType.ALL ,
    fetch= FetchType.EAGER)
    private List<Chambre> chambres;

    @ManyToOne
    private Foyer foyer;
}
