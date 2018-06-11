package com.opendevup.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table( name = "Depense" )
public class Depense {
	
	@Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "idDepense" )
	private Long idDepense;
	private String typeDepense;
	private Double montant;
	private String justificatif;
	@ManyToOne
	@JoinColumn( name = "mission_fk" )
	@JsonIgnore
	private Mission mission_fk = new Mission();
	
	public Depense() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Depense(String typeDepense, Double montant, String justificatif, Mission mission_fk) {
		super();
		this.typeDepense = typeDepense;
		this.montant = montant;
		this.justificatif = justificatif;
		this.mission_fk = mission_fk;
	}

	public Long getIdDepense() {
		return idDepense;
	}

	public void setIdDepense(Long idDepense) {
		this.idDepense = idDepense;
	}

	public String getTypeDepense() {
		return typeDepense;
	}

	public void setTypeDepense(String typeDepense) {
		this.typeDepense = typeDepense;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public String getJustificatif() {
		return justificatif;
	}

	public void setJustificatif(String justificatif) {
		this.justificatif = justificatif;
	}

	public Mission getMission_fk() {
		return mission_fk;
	}

	public void setMission_fk(Mission mission_fk) {
		this.mission_fk = mission_fk;
	}

	
	
}
