package com.opendevup.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "Etatsmission" )
public class EtatsMission {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "idetats" )
    private Long   idEtats;

    private Long   idmission;

    private String etat;

    private String typemissionnaire;
    
    private String typemission;
    
    private String etatRemboursement;

    public EtatsMission() {
        super();
        // TODO Auto-generated constructor stub
    }

    public EtatsMission( Long idmission, String etat, String typemissionnaire ) {
        super();
        this.idmission = idmission;
        this.etat = etat;
        this.typemissionnaire = typemissionnaire;
    }
    

    public EtatsMission(Long idmission, String etat, String typemissionnaire, String typemission) {
		super();
		this.idmission = idmission;
		this.etat = etat;
		this.typemissionnaire = typemissionnaire;
		this.typemission = typemission;
	}

	public Long getIdEtats() {
        return idEtats;
    }

    public void setIdEtats( Long idEtats ) {
        this.idEtats = idEtats;
    }

    public Long getIdmission() {
        return idmission;
    }

    public void setIdmission( Long idmission ) {
        this.idmission = idmission;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat( String etat ) {
        this.etat = etat;
    }

    public String getTypemissionnaire() {
        return typemissionnaire;
    }

    public void setTypemissionnaire( String typemissionnaire ) {
        this.typemissionnaire = typemissionnaire;
    }

	public String getTypeMission() {
		return typemission;
	}

	public void setTypeMission(String typemission) {
		this.typemission = typemission;
	}

	public String getEtatRemboursement() {
		return etatRemboursement;
	}

	public void setEtatRemboursement(String etatRemboursement) {
		this.etatRemboursement = etatRemboursement;
	}
	
}
