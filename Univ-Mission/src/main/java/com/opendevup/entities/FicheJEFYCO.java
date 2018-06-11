package com.opendevup.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table( name = "FicheJEFYCO" )
public class FicheJEFYCO {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "idFicheJEFYCO" )
    private int          idFicheJEFYCO;

    @Column( name = "numeroLnSee" )
    private Double       numeroLnSee;

    @Column( name = "cle" )
    private int          cle;

    @Column( name = "typePersonnel" )
    private String       typePersonnel;

    @Column( name = "profession" )
    private String       profession;

    @Column( name = "precision1" )
    private String       precision1;

    @Column( name = "codeBanque" )
    private int          codeBanque;

    @Column( name = "codeGuichet" )
    private int          codeGuichet;

    @Column( name = "compte" )
    private String       compte;

    @Column( name = "domiciliation" )
    private String       domiciliation;

    @Column( name = "iban" )
    private String       iban;

    @Column( name = "bic" )
    private String       BIC;

    @OneToOne
    private Missionnaire missionnaire;

    public FicheJEFYCO() {
        super();
        // TODO Auto-generated constructor stub
    }

    public FicheJEFYCO( int idFicheJEFYCO, Double numeroLnSee, int cle, String typePersonnel,
            String profession, String precision1, int codeBanque, int codeGuichet, String compte, String domiciliation,
            String iban, String bIC ) {
        super();
        this.idFicheJEFYCO = idFicheJEFYCO;
        this.numeroLnSee = numeroLnSee;
        this.cle = cle;
        this.typePersonnel = typePersonnel;
        this.profession = profession;
        this.precision1 = precision1;
        this.codeBanque = codeBanque;
        this.codeGuichet = codeGuichet;
        this.compte = compte;
        this.domiciliation = domiciliation;
        this.iban = iban;
        BIC = bIC;
    }

    public int getIdFicheJEFYCO() {
        return idFicheJEFYCO;
    }

    public void setIdFicheJEFYCO( int idFicheJEFYCO ) {
        this.idFicheJEFYCO = idFicheJEFYCO;
    }

    public Double getNumeroLnSee() {
        return numeroLnSee;
    }

    public void setNumeroLnSee( Double numeroLnSee ) {
        this.numeroLnSee = numeroLnSee;
    }

    public int getCle() {
        return cle;
    }

    public void setCle( int cle ) {
        this.cle = cle;
    }

    public String getTypePersonnel() {
        return typePersonnel;
    }

    public void setTypePersonnel( String typePersonnel ) {
        this.typePersonnel = typePersonnel;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession( String profession ) {
        this.profession = profession;
    }

    public String getPrecision1() {
        return precision1;
    }

    public void setPrecision1( String precision1 ) {
        this.precision1 = precision1;
    }

    public int getCodeBanque() {
        return codeBanque;
    }

    public void setCodeBanque( int codeBanque ) {
        this.codeBanque = codeBanque;
    }

    public int getCodeGuichet() {
        return codeGuichet;
    }

    public void setCodeGuichet( int codeGuichet ) {
        this.codeGuichet = codeGuichet;
    }

    public String getCompte() {
        return compte;
    }

    public void setCompte( String compte ) {
        this.compte = compte;
    }

    public String getDomiciliation() {
        return domiciliation;
    }

    public void setDomiciliation( String domiciliation ) {
        this.domiciliation = domiciliation;
    }

    public String getIban() {
        return iban;
    }

    public void setIban( String iban ) {
        this.iban = iban;
    }

    public String getBIC() {
        return BIC;
    }

    public void setBIC( String bIC ) {
        BIC = bIC;
    }

    public Missionnaire getMissionnaire() {
        return missionnaire;
    }

    public void setMissionnaire( Missionnaire missionnaire ) {
        this.missionnaire = missionnaire;
    }

}
