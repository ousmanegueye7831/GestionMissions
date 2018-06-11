package com.opendevup.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.opendevup.entities.Deplacement;
import com.opendevup.metier.DeplacementMetier;
import com.opendevup.services.entities.MultipleMissionDeplacement;

@RestController
@CrossOrigin( "*" )
public class DeplacementRestService {
	@Autowired
	private DeplacementMetier deplacementMetier;
	@RequestMapping( value = "/Deplacement/save", method = RequestMethod.POST )
	public Boolean saveDeplacement(@RequestBody MultipleMissionDeplacement deplacement) {
		return deplacementMetier.saveDeplacement(deplacement);
	}
	

}
