package com.defitech.tp_vente.controller;

import com.defitech.tp_vente.modele.Appro;
import com.defitech.tp_vente.service.ApproService;
import com.defitech.tp_vente.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class ApproController {
    @Autowired
    private ApproService approService;
    @Autowired
    private ArticleService articleService;

    @GetMapping("/approShow")
    public String showAllAppro(Model model) {
        model.addAttribute("listeAppro", approService.showAllAppro());
        //pas obligé d'avoir le mm nom que le return
        return "admin/ListeAppro";
    }

    @GetMapping("/approForm")
    public String ShowFormAppro(Model model) {
        model.addAttribute("listeAppro", articleService.showAllArticles());
        return "admin/FormAppro";
    }

    @PostMapping("/appro/save")
    public String saveAppro(Appro appro) {
        appro.setQteAppro(appro.getQteAppro());
        appro.setDateAppro(LocalDate.now());
        approService.saveAppro(appro);
        articleService.updateStockArticle(appro.getQteAppro(), appro.getArticleId());
        return "redirect:/approShow";
    }

    @GetMapping("/approEdit{id}")
    public String approEdit(@PathVariable("id") int id, Model model) {
        model.addAttribute("Un_approvisionnement", approService.showOneAppro(id));
        model.addAttribute("listeAppro", articleService.showAllArticles());
        return "admin/approEdit";
    }

    @PostMapping("appro/update")
    public String updateAppro(@ModelAttribute("approvisionnement") Appro appro) {
        approService.saveAppro(appro);
        return "redirect:/approShow";

    }

    @GetMapping("/appro/delete{id}")
    public String deleteAppro(@PathVariable("id") int id) {
        approService.deleteAppro(id);
        return "redirect:/approShow";

    }

    //Ajouter pr rétablir un seuil critique
    @GetMapping("/articleApproEdit{id}")
    public String addAppro(@PathVariable("id") int id, Model model) {
        model.addAttribute("un_article", articleService.showOneArticle(id));
        return "admin/approEditSeuil";
    }

    @PostMapping("/article/appro/update")
    public String updateOneAppro(@RequestParam String id, @RequestParam String qte) {
        Appro appro = new Appro();
        appro.setDateAppro(LocalDate.now());
        //System.out.println("***********************"+qte+"*******************"+id);
        appro.setQteAppro(Integer.parseInt(qte));
        appro.setArticleId(Integer.parseInt(id));
        approService.saveAppro(appro);
        articleService.updateStockArticle(appro.getQteAppro(), appro.getArticleId());
        return "redirect:/approShow";
    }

    @GetMapping("/qte/appro")
    public String ListeA(Model model, @RequestParam int qteAppro){
        model.addAttribute("listeByQteAppro",approService.findByQuantiteApr(qteAppro));
        return "/admin/ListeQteAppro";
    }

    @PostMapping("/appro/qteAppro")
    public String listeByname(@RequestParam int qte){
       approService.findByQuantiteApr(qte);
        return "redirect:/qte/appro";
    }

}

