package com.defitech.tp_vente.service;

import com.defitech.tp_vente.modele.Vente;
import com.defitech.tp_vente.repository.ArticleReposirory;
import com.defitech.tp_vente.repository.VenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenteService {
    @Autowired
    private VenteRepository venteRepository;
    @Autowired
    private ArticleReposirory articleReposirory;


    public void saveVente(Vente vente) {venteRepository.save(vente);
    }

    public List<Vente> showAllVente() {
        return venteRepository.findAll();}

    public Vente showOnevente(int id){
        return venteRepository.findById(id).get();
    }
    public void deleteVente(int id){venteRepository.deleteById(id);}
   /* public void degradeStock(int qte_art, int id_Art){
        articleReposirory.degradeStockArticle(qte_art, id_Art);}*/

   public List<Vente> findByQuantiteVente(int qteVente){
       return venteRepository.findByQuant(qteVente);
   }


}
