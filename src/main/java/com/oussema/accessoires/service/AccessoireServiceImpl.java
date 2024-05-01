package com.oussema.accessoires.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.oussema.accessoires.entities.Accessoire;
import com.oussema.accessoires.entities.Marque;
import com.oussema.accessoires.repos.AccessoireRepository;

@Service
public class AccessoireServiceImpl implements AccessoireService {
	@Autowired
	AccessoireRepository accessoireRepository;

	@Override
	public Accessoire saveAccessoire(Accessoire p) {
		return accessoireRepository.save(p);
	}

	@Override
	public Accessoire updateAccessoire(Accessoire p) {
		return accessoireRepository.save(p);
	}

	@Override
	public void deleteAccessoire(Accessoire p) {
		accessoireRepository.delete(p);
		
	}

	@Override
	public void deleteAccessoireById(Long id) {
		accessoireRepository.deleteById(id);
		
	}

	@Override
	public Accessoire getAccessoire(Long id) {
		return accessoireRepository.findById(id).get();
	}

	@Override
	public List<Accessoire> getAllAccessoires() {
		return accessoireRepository.findAll();
	}
	@Override
	public Page<Accessoire> getAllAccessoiresParPage(int page, int size) {
		return accessoireRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Accessoire> findByLibAccessoire(String lib) {
		return accessoireRepository.findByLibAccessoire(lib);
	}

	@Override
	public List<Accessoire> findByLibAccessoireContains(String lib) {
		return accessoireRepository.findByLibAccessoireContains(lib);
	}

	@Override
	public List<Accessoire> findByLibPrix(String lib, Double prix) {
		return accessoireRepository.findByLibPrix(lib, prix);
	}

	@Override
	public List<Accessoire> findByMarque(Marque marque) {
		return accessoireRepository.findByMarque(marque);
	}

	@Override
	public List<Accessoire> findByMarqueIdMar(Long id) {
		return accessoireRepository.findByMarqueIdMar(id);
	}

	@Override
	public List<Accessoire> findByOrderByLibAccessoireAsc() {
		return accessoireRepository.findByOrderByLibAccessoireAsc();
	}

	@Override
	public List<Accessoire> trierAccessoiresLibsPrix() {
		return accessoireRepository.trierAccessoiresLibsPrix();
	}

}
