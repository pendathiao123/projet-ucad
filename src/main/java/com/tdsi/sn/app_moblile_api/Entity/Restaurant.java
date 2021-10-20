package com.tdsi.sn.app_moblile_api.Entity;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idresto;

    private String nom;
    @OneToMany(

            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
     List<Controlleur> controlleurs = new ArrayList<>();

}
