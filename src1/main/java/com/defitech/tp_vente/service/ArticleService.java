package com.defitech.tp_vente.service;

import com.defitech.tp_vente.modele.Article;
import com.defitech.tp_vente.modele.Constante;
import com.defitech.tp_vente.repository.ArticleReposirory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleReposirory articleRepository;
    public void saveArticle(Article article){
        articleRepository.save(article);
    }

    public List<Article> showAllArticles(){
        return articleRepository.findAll();
    }

    public Article showOneArticle(int id){
        return articleRepository.findById(id).get();
    }

    public void deleteArticle(int id){
        articleRepository.deleteById(id);
    }
    public void updateStockArticle(int qte, int id){
        articleRepository.updateStockArticle(qte, id);
    }
    public void degrade(int qte_art, int id_Art){
        articleRepository.degradeStockArticle(qte_art, id_Art);
    }

    public List<Article> findByLibelle(String libelle){
      return articleRepository.findByName(libelle);
    }
   /* public int totalArticle(int art){
        return articleRepository.CountArticle(art);
    }*/

    public List<Article> changerEtatArticle(List<Article> liste){
        for (Article a:liste){
            if (a.getQteSeuil()>a.getQteStock()){
                a.setEtat(Constante.ETAT_CRITIQUE);
            }
            else{
                a.setEtat(Constante.ETAT_NORMAL);
            }
            if (0>a.getQteStock()){
                a.setEtat(Constante.ETAT_DANGER);
            }
        }
        return liste;
    }

    public List<Article> articleEtatCritique(List<Article> liste){
        List<Article> listeSeuil=new ArrayList<>();
        for (Article a:liste){
            if (a.getQteSeuil()>a.getQteStock()){
                listeSeuil.add(a);
            }
        }
        return listeSeuil;
    }
    public List<Article> findByName(List<Article> liste) {
        List<Article> listeName = new ArrayList<>();
        for (Article a : liste) {
            if (a.getLibelle() == a.getDesi()) {
                listeName.add(a);
            }
        }
        return listeName;

    }
}
