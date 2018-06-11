package com.opendevup.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table( name = "Remboursement" )
public class Remboursement {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "idRemboursement" )
    private Long    idRemboursement;
   
    

    @Column( name = "etat" )
    private Boolean etat;

    public Remboursement() {
        super();
        // TODO Auto-generated constructor stub
    }

	public Long getIdRemboursement() {
		return idRemboursement;
	}

	public void setIdRemboursement(Long idRemboursement) {
		this.idRemboursement = idRemboursement;
	}

	public Boolean getEtat() {
		return etat;
	}

	public void setEtat(Boolean etat) {
		this.etat = etat;
	}

	
    
  
}
