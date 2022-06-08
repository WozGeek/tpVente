package com.defitech.tp_vente.controller;

import com.defitech.tp_vente.modele.Article;
import com.defitech.tp_vente.service.ArticleService;
import com.defitech.tp_vente.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class ArticleController {

    @Autowired
    private CategorieService categorieService;
    @Autowired
    private ArticleService articleService;

    @GetMapping("/articlesShow")
    public String showAllArticles(Model model){
        model.addAttribute("listeArticle",articleService.changerEtatArticle(articleService.showAllArticles()));
        //pas obligé d'avoir le mm nom que le return
        return "admin/ListesArticles";
    }

    @GetMapping("/articlesForm")
    public String ShowFormArticle(Model model){
        model.addAttribute("listeCategorie",categorieService.showAllCategories());
        return "admin/FormArticles";
    }
    @PostMapping("/articles/save")
    public String saveArticle(Article article,Model model){
        article.setQteStock(0);
        article.setDateCreation(LocalDate.now());
        articleService.saveArticle(article);
        return "redirect:/articlesShow";
    }

    @GetMapping("/articleEdit{id}")
    public String formEdit(@PathVariable("id") int id, Model model){
        model.addAttribute("Un_article",articleService.showOneArticle(id));
        model.addAttribute("listeCategorie",categorieService.showAllCategories());
        return "admin/FormEdit";
    }
    @PostMapping("articles/update")
     public  String updateArticle(@ModelAttribute("article") Article article){
        articleService.saveArticle(article);
        return "redirect:/articlesShow";

     }

    /* @PostMapping("/total")
    public String  totalCountArticle(int id,Model model){
        model.addAttribute("nombreTotal",articleService.totalArticle(id));
        //articleService.totalArticle(id);
        return "redirect:/articlesShow";
    }*/

    @GetMapping("/article/delete/{id}")
    public String deleteArticle(@PathVariable("id") int id){
        articleService.deleteArticle(id);
        return "redirect:/articlesShow";
    }


    @GetMapping("/articlesEtatSeuil")
    public String listeSeuil(Model model){
        model.addAttribute("listeSeuil",articleService.articleEtatCritique(articleService.showAllArticles()));
        return "admin/ListeSeuil";
    }

    @GetMapping("/name")
    public String Liste(Model model, @RequestParam String libelle){
        model.addAttribute("listeByNamer",articleService.findByLibelle(libelle));
        return "/admin/ListeName";
    }

    @PostMapping("/articles/nom")
    public String listeByname(@RequestParam String desi){
        articleService.findByLibelle(desi);
        return "redirect:/name";
    }
}
