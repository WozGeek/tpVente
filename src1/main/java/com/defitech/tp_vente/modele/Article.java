package com.defitech.tp_vente.modele;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = )

public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto increment apres creation de la table
    //@Column(name= "ArticleId") changement de nom de la clé primaire
    private int id;
    private String libelle;
    private  double prix;
    private int qteStock;
    @DateTimeFormat(pattern = "yyyy/MM/dd")//format de la date (valable juste en dessous)
    private LocalDate dateCreation;
    private int qteSeuil;
    @Transient
    private String etat;

    /*@Transient
    private String desi;*/

    @Transient
    private String desi;


    @ManyToOne//pour une categorie j'ai plusieurs articles
    @JoinColumn(name= "categorieId",insertable = false, updatable = false)
    private Categorie categorie;
    private int categorieId;
}
