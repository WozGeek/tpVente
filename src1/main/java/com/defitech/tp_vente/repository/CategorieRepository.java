package com.defitech.tp_vente.repository;

import com.defitech.tp_vente.modele.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie,Integer> {
    @Query("select c from Categorie c where c.designation like %?1%")
    List<Categorie> findByDesignation(String desi);
}
