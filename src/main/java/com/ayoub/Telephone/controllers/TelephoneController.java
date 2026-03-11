package com.ayoub.Telephone.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ayoub.Telephone.entities.Telephone;
import com.ayoub.Telephone.entities.Statut;
import com.ayoub.Telephone.service.TelephoneService;

@Controller
public class TelephoneController {

    @Autowired
    private TelephoneService telService;

    // Liste des téléphones avec pagination
    @RequestMapping("/listeTelephones")
    public String listeTelephones(ModelMap modelMap,
                                  @RequestParam(name="page", defaultValue="0") int page,
                                  @RequestParam(name="size", defaultValue="2") int size) {
        Page<Telephone> tels = telService.getAllTelsParPage(page, size);
        modelMap.addAttribute("tels", tels);
        modelMap.addAttribute("pages", new int[tels.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "listeTelephones";
    }


    @RequestMapping("/showCreateTel")
    public String showCreate(ModelMap modelMap) {
        List<Statut> statuts = telService.getAllStatuts();
        Telephone tel = new Telephone();
        tel.setDateCreation(new Date());
        modelMap.addAttribute("telephone", tel);
        modelMap.addAttribute("mode", "new");
        modelMap.addAttribute("statuts", statuts);
        return "formTel";
    }


    @RequestMapping("/saveTel")
    public String saveTel(@Valid @ModelAttribute("telephone") Telephone tel,
                          BindingResult bindingResult,
                          ModelMap modelMap,
                          @RequestParam(name="page", defaultValue="0") int page,
                          @RequestParam(name="size", defaultValue="2") int size,
                          @RequestParam(name="statutId", required=false) Long statutId) {


        if (statutId != null) {
            tel.setStatut(telService.getStatutById(statutId));
        }


        boolean hasRealErrors = bindingResult.getFieldErrors().stream()
                .anyMatch(error -> !error.getField().equals("idtel"));

        if (hasRealErrors) {
            List<Statut> statuts = telService.getAllStatuts();
            modelMap.addAttribute("telephone", tel);
            modelMap.addAttribute("statuts", statuts);
            modelMap.addAttribute("mode", tel.getIdtel() == null ? "new" : "edit");
            modelMap.addAttribute("page", page);
            modelMap.addAttribute("size", size);
            return "formTel";
        }

        boolean isNew = (tel.getIdtel() == null);
        telService.saveTel(tel);

        int currentPage;
        if (isNew) {
            Page<Telephone> tels = telService.getAllTelsParPage(page, size);
            currentPage = tels.getTotalPages() - 1;
        } else {
            currentPage = page;
        }

        return "redirect:/listeTelephones?page=" + currentPage + "&size=" + size;
    }


    @RequestMapping("/supprimerTel")
    public String supprimerTel(@RequestParam("id") Long id,
                               @RequestParam(name="page", defaultValue="0") int page,
                               @RequestParam(name="size", defaultValue="2") int size) {
        telService.deleteTelById(id);
        return "redirect:/listeTelephones?page=" + page + "&size=" + size;
    }


    @RequestMapping("/modifierTel")
    public String modifierTel(@RequestParam("id") Long id,
                              ModelMap modelMap,
                              @RequestParam(name="page", defaultValue="0") int page,
                              @RequestParam(name="size", defaultValue="2") int size) {
        List<Statut> statuts = telService.getAllStatuts();
        Telephone tel = telService.getTel(id);
        modelMap.addAttribute("telephone", tel);
        modelMap.addAttribute("mode", "edit");
        modelMap.addAttribute("statuts", statuts);
        modelMap.addAttribute("page", page);
        modelMap.addAttribute("size", size);
        return "formTel";
    }
}