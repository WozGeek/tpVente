package com.defitech.tp_vente.repository;

import com.defitech.tp_vente.modele.Appro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApproRepository extends JpaRepository<Appro,Integer> {
    @Query("select a from Appro a where a.qteAppro like %?1%")
    List<Appro> findByQuant(int qte);
}
