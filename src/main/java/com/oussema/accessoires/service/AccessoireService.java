package com.oussema.accessoires.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.oussema.accessoires.entities.Accessoire;

public interface AccessoireService {
	Accessoire saveAccessoire(Accessoire p);

	Accessoire updateAccessoire(Accessoire p);

	void deleteAccessoire(Accessoire p);

	void deleteAccessoireById(Long id);

	Accessoire getAccessoire(Long id);

	List<Accessoire> getAllAccessoires();

	Page<Accessoire> getAllAccessoiresParPage(int page, int size);

}
