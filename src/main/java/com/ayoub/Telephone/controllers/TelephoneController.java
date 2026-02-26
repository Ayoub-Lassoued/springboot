package com.ayoub.Telephone.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ayoub.Telephone.entities.Telephone;
import com.ayoub.Telephone.service.TelephoneService;


@Controller
public class TelephoneController {
	 @Autowired
	    private TelephoneService telService;


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
	    public String showCreate() {
	       
	        return "createTel";
	    }
	/*
	    @RequestMapping("/saveTel")
	    public String saveTel(@Valid Tel tel, BindingResult bindingResult,
	                          ModelMap modelMap,
	                          @RequestParam(name="page", defaultValue="0") int page,
	                          @RequestParam(name="size", defaultValue="2") int size) {

	        if (bindingResult.hasErrors()) {
	         
	            modelMap.addAttribute("mode", tel.getIdtel() == null ? "new" : "edit");
	            return "formTelephones";
	        }

	        boolean isNew = (tel.getIdtel() == null);
	        telService.saveTel(tel);

	        int currentPage = page;
	        if (isNew) {
	            Page<Tel> tels = telService.getAllTelsParPage(page, size);
	            currentPage = tels.getTotalPages() - 1;
	        }

	        return "redirect:/ListeTelephones?page=" + currentPage + "&size=" + size;
	    }
	    */
	    
	    @RequestMapping("/saveTel")
		public String saveTel(@ModelAttribute("tel") Telephone tel,
		@RequestParam("date") String date,
		ModelMap modelMap) throws ParseException
		{
		//conversion de la date
		 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		 Date dateC = dateformat.parse(String.valueOf(date));
		 tel.setDateCreation(dateC);

		 Telephone saveTel = telService.saveTel(tel);
		String msg ="project enregistré avec Id "+saveTel.getIdtel();
		modelMap.addAttribute("msg", msg);
		return "createTel";
		}
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    


	    @RequestMapping("/supprimerTel")
	    public String supprimerTel(ModelMap modelMap,@RequestParam("id") Long id,
	                               @RequestParam(name="page", defaultValue="0") int page,
	                               @RequestParam(name="size", defaultValue="2") int size) {
	        telService.deleteTelById(id);
	        Page<Telephone> tels = telService.getAllTelsParPage(page, size);
	        modelMap.addAttribute("tels", tels);
	        modelMap.addAttribute("pages", new int[tels.getTotalPages()]);
	        modelMap.addAttribute("currentPage", page);
	        modelMap.addAttribute("size", size);
	        return "listeTelephones";
	    }
	    

	 
	    @RequestMapping("/modifierTel")
	    public String modifierTel(@RequestParam("id") Long id,
	                              ModelMap modelMap,
	                              @RequestParam(name="page", defaultValue="0") int page,
	                              @RequestParam(name="size", defaultValue="2") int size) {

	        Telephone tel = telService.getTel(id);
	        modelMap.addAttribute("tel", tel);
	   
	        return "editerTel";
	    }


	    @RequestMapping("/updateTel")
	    public String updateTel(@ModelAttribute("tel") Telephone tel,
	                            @RequestParam("date") String date,
	                            ModelMap modelMap) throws ParseException {

	        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	        Date dateCreation = dateformat.parse(date);
	        tel.setDateCreation(dateCreation);
	        telService.updateTel(tel);
	        List<Telephone> tels = telService.getAllTels();
	        modelMap.addAttribute("tels", tels);
	        return "listeTelephones";
	    }

}
