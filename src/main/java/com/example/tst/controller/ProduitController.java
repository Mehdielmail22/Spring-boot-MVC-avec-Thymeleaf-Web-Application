package com.example.tst.controller;

import com.example.tst.Model.Produit;
import com.example.tst.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ProduitController {
    @Autowired
    private ProduitRepository produitrepository;

    @GetMapping("/index")
    public String Index(Model model){
        List<Produit>  produits= (List<Produit>) produitrepository.findAll();

        model.addAttribute("produits",produits);
        return  "index";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("produit",new Produit());
        return "add";
    }
    @RequestMapping("/create")
    public String create(@ModelAttribute("produit") Produit produit){
        produitrepository.save(produit);
        return"redirect:/index";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") long id){
        produitrepository.deleteById(id);
        return"redirect:/index";

    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") long id,Model model){
        model.addAttribute("id",id);
        model.addAttribute("nom",produitrepository.findById(id).get().getNom());
        return "edit";
    }
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") long id,Model model){
       Produit produit= produitrepository.findById(id).get();
       model.addAttribute("produit",produit);
       return "detail";
    }
    @RequestMapping("/saveedit")
    public String saveEdit(@RequestParam("id") String id,@RequestParam("nom") String nom,@RequestParam("prix") String prix){
        produitrepository.save(new Produit(Long.parseLong(id),nom,Float.parseFloat(prix)));
        return "redirect:/index";
    }
    @GetMapping("/serch/{nom}")
    public String search(@PathVariable("nom") String nom,Model model){
       List<Produit> produits= (List<Produit>) produitrepository.findAll();
       List<Produit> result=null;
       for(int i=0;i<produits.size();i++){
           if(produits.get(i).getNom().equals(nom)){
               result.add(produits.get(i));
           }
       }
       model.addAttribute("produits",produits);
       return "index";
    }
    @GetMapping("/index2")
    public String index2(Model model){
        long a=1;
        Produit produit=produitrepository.findById(a).get();
        model.addAttribute("produit",produit);
        return "aa/index2";
    }

    @RequestMapping("/index")


    



}
