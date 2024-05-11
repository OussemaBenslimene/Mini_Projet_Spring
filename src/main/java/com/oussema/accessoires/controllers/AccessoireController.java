package com.oussema.accessoires.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oussema.accessoires.entities.Accessoire;
import com.oussema.accessoires.entities.Marque;
import com.oussema.accessoires.service.AccessoireService;

import jakarta.validation.Valid;


@Controller
public class AccessoireController {
	@Autowired
	AccessoireService accessoireService;

	@RequestMapping("/myview")
	public String myView() {
		return "myView";
	}

	@RequestMapping("/ListeAccessoires")
	public String listeProduits(ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		Page<Accessoire> acc = accessoireService.getAllAccessoiresParPage(page, size);
		modelMap.addAttribute("accessoires", acc);
		modelMap.addAttribute("pages", new int[acc.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeAccessoires";
	}

	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap) {
		
		List<Marque> mqs = accessoireService.getAllMarques();
		modelMap.addAttribute("accessoire", new Accessoire());
		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("marques", mqs);
		return "formAccessoire";
	}

	@RequestMapping("/saveAccessoire")
	public String saveAccessoire(@Valid Accessoire accessoire,
			BindingResult bindingResult,
			@RequestParam (name = "page" , defaultValue = "0") int page,
			@RequestParam (name = "size" , defaultValue = "2") int size ) {
		System.out.println(page + " " + size);
		
		int currentPage;
		boolean isNew = false;

		
		if (bindingResult.hasErrors()) return "formAccessoire";
		
		if (accessoire.getIdAccessoire()==null) //ajout
			isNew=true;

		
		accessoireService.saveAccessoire(accessoire);
		if (isNew) //ajout
		{
		Page<Accessoire> accs = accessoireService.getAllAccessoiresParPage(page, size);
		currentPage = accs.getTotalPages()-1;
		}
		else //modif
		currentPage=page;
		//return "ListeProduits";
		return ("redirect:/ListeAccessoires?page="+currentPage+"&size="+size);
	}

	@RequestMapping("/supprimerAccessoire")
	public String supprimerAccessoire(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		
		accessoireService.deleteAccessoireById(id);
		Page<Accessoire> acc = accessoireService.getAllAccessoiresParPage(page, size);
		modelMap.addAttribute("accessoires", acc);
		modelMap.addAttribute("pages", new int[acc.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeAccessoires";
	}

	@RequestMapping("/modifierAccessoire")
	public String editerProduit(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam (name = "page" , defaultValue = "0") int page,
			@RequestParam (name = "size" , defaultValue = "2") int size) {
		
		Accessoire p = accessoireService.getAccessoire(id);
		List<Marque> mqs = accessoireService.getAllMarques();
		modelMap.addAttribute("accessoire", p);
		modelMap.addAttribute("mode", "edit");
		modelMap.addAttribute("marques", mqs);
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("size", size);
		return "formAccessoire";
	}

	@RequestMapping("/updateAccessoire")
	public String updateProduit(@ModelAttribute("accessoire") Accessoire accessoire, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {
//conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		accessoire.setDateCreation(dateCreation);

		accessoireService.updateAccessoire(accessoire);
		List<Accessoire> prods = accessoireService.getAllAccessoires();
		modelMap.addAttribute("produits", prods);
		return "listeAccessoires";
	}
	
	@GetMapping(value = "/")
	public String welcome() {
	 return "index";
	}

}
