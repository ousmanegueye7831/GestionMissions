package com.opendevup.metier;

import java.util.List;


import com.opendevup.entities.FicheJEFYCO;
import com.opendevup.services.entities.MultipleFicheMissionnaire;

public interface FicheJEFYCOMetier {
	public FicheJEFYCO saveFicheJefyco( MultipleFicheMissionnaire fm );
    public List<FicheJEFYCO> listeFichesJEFYCO(); //ListFichesJEFYCO
    public FicheJEFYCO getFicheJEFYCO( Long id );
    public Boolean deleteFicheJEFYCO( Long id );  //deleteJEFYCO
}
