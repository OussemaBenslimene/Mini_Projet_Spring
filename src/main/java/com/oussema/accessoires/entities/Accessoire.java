package com.oussema.accessoires.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Accessoire {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAccessoire;
	
	@NotNull
	@Size (min = 4,max = 50)
	private String libAccessoire;
	
	@Min(value = 10)
	@Max(value = 10000)
	private Double prixAccessoire;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date dateCreation;
	
	@ManyToOne
	private Marque marque;
	
	public Marque getMarque() {
		return marque;
	}
	public void setMarque(Marque marque) {
		this.marque = marque;
	}
	public Accessoire() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Accessoire(String libAccessoire, Double prixAccessoire, Date dateCreation) {
		super();
		this.libAccessoire = libAccessoire;
		this.prixAccessoire = prixAccessoire;
		this.dateCreation = dateCreation;
	}
	public Long getIdAccessoire() {
		return idAccessoire;
	}
	public void setIdAccessoire(Long idAccessoire) {
		this.idAccessoire = idAccessoire;
	}
	public String getLibAccessoire() {
		return libAccessoire;
	}
	public void setLibAccessoire(String libAccessoire) {
		this.libAccessoire = libAccessoire;
	}
	public Double getPrixAccessoire() {
		return prixAccessoire;
	}
	public void setPrixAccessoire(Double prixAccessoire) {
		this.prixAccessoire = prixAccessoire;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	@Override
	public String toString() {
		return "Accessoire [idAccessoire=" + idAccessoire + ", libAccessoire=" + libAccessoire + ", prixAccessoire="
				+ prixAccessoire + ", dateCreation=" + dateCreation + "]";
	}
	

}
