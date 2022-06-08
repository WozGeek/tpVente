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
public class Appro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int qteAppro;
    @DateTimeFormat(pattern = "yyyy/MM/dd")//format de la date (valable juste en dessous)
    private LocalDate dateAppro;
    @ManyToOne//pour une categorie j'ai plusieurs articles
    @JoinColumn(name= "articleId",insertable = false, updatable = false)
    private Article article;
    private int articleId;
}
