package com.opendevup.services.entities;

import com.opendevup.entities.FicheJEFYCO;
import com.opendevup.entities.Missionnaire;

public class MultipleFicheMissionnaire {

    private int          idMultipleMissionnaire;

    private FicheJEFYCO  fiche;

    private Missionnaire missionnaire;

    public MultipleFicheMissionnaire() {
        super();
        // TODO Auto-generated constructor stub
    }

    public MultipleFicheMissionnaire( int idMultipleMissionnaire, FicheJEFYCO fiche ) {
        super();
        this.idMultipleMissionnaire = idMultipleMissionnaire;
        this.fiche = fiche;
    }

    public int getIdMultipleMissionnaire() {
        return idMultipleMissionnaire;
    }

    public void setIdMultipleMissionnaire( int idMultipleMissionnaire ) {
        this.idMultipleMissionnaire = idMultipleMissionnaire;
    }

    public FicheJEFYCO getFiche() {
        return fiche;
    }

    public void setFiche( FicheJEFYCO fiche ) {
        this.fiche = fiche;
    }

    public Missionnaire getMissionnaire() {
        return missionnaire;
    }

    public void setMissionnaire( Missionnaire missionnaire ) {
        this.missionnaire = missionnaire;
    }

}
