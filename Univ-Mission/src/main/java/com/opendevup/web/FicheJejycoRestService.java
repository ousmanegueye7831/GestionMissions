package com.opendevup.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.opendevup.entities.FicheJEFYCO;
import com.opendevup.metier.FicheJEFYCOMetier;
import com.opendevup.services.entities.MultipleFicheMissionnaire;

@RestController
@CrossOrigin( "*" )
public class FicheJejycoRestService {
	
	@Autowired
	private FicheJEFYCOMetier ficheJeficoMetier;
	
	@RequestMapping( value = "/FicheJEFYCO/save", method = RequestMethod.POST )
	public FicheJEFYCO saveFicheJefyco(@RequestBody MultipleFicheMissionnaire fm) {
		return ficheJeficoMetier.saveFicheJefyco(fm);
	}
    @RequestMapping( value = "/FicheJEFYCO/list", method = RequestMethod.GET )
	public List<FicheJEFYCO> listeFichesJEFYCO() {
		return ficheJeficoMetier.listeFichesJEFYCO();
	}
    @RequestMapping( value = "/FicheJEFYCO/find/{id}", method = RequestMethod.GET )
	public FicheJEFYCO getFicheJEFYCO( @PathVariable( "id" ) Long id) {
		return ficheJeficoMetier.getFicheJEFYCO(id);
	}
    @RequestMapping( value = "/FicheJEFYCO/delete/{id}", method = RequestMethod.DELETE )
	public Boolean deleteFicheJEFYCO( @PathVariable( "id" ) Long id) {
		return ficheJeficoMetier.deleteFicheJEFYCO(id);
	}

}
