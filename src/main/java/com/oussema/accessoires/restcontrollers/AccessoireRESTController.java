package com.oussema.accessoires.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oussema.accessoires.entities.Accessoire;
import com.oussema.accessoires.service.AccessoireService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AccessoireRESTController {

	@Autowired
	AccessoireService accService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Accessoire> getAllAccessoires() {
		return accService.getAllAccessoires();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Accessoire getAccessoireById(@PathVariable("id") Long id) {
		return accService.getAccessoire(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Accessoire createAccessoire(@RequestBody Accessoire accessoire) {
		return accService.saveAccessoire(accessoire);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Accessoire updateAccessoire(@RequestBody Accessoire accessoire) {
		return accService.updateAccessoire(accessoire);
	}
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteAccessoire(@PathVariable("id") Long id)
	{
		accService.deleteAccessoireById(id);
	}
	@RequestMapping(value="/accmarque/{idMar}",method = RequestMethod.GET)
	public List<Accessoire> getProduitsByCatId(@PathVariable("idMar") Long idMar) {
	return accService.findByMarqueIdMar(idMar);
	}
}
