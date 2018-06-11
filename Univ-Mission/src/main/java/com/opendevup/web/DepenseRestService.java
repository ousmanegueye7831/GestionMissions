package com.opendevup.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.opendevup.entities.Depense;
import com.opendevup.metier.DepenseMetier;
import com.opendevup.services.entities.MultipleMissionDepense;

@RestController
@CrossOrigin( "*" )
public class DepenseRestService {
	@Autowired
	private DepenseMetier depenseMetier;
	@RequestMapping( value = "/Depense/save", method = RequestMethod.POST )
	public Boolean saveDepense(@RequestBody MultipleMissionDepense depense) {
		return depenseMetier.saveDepense(depense);
	}
	
}
