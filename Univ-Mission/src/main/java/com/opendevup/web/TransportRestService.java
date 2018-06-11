package com.opendevup.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.opendevup.entities.Transport;
import com.opendevup.metier.TransportMetier;

@RestController
@CrossOrigin( "*" )
public class TransportRestService {
	@Autowired
	private TransportMetier transportMetier;

    @RequestMapping( value = "/Transport/save", method = RequestMethod.POST )
	public Transport saveTransport(@RequestBody Transport t) {
		return transportMetier.saveTransport(t);
	}
    
    @RequestMapping( value = "/Transport/find/{id}", method = RequestMethod.GET )
	public Transport getTransport(@PathVariable( "id" ) Long id) {
		return transportMetier.getTransport(id);
	}
    
    @RequestMapping( value = "/Transport/delete/{id}", method = RequestMethod.DELETE )
	public Boolean deleteTransport(@PathVariable( "id" ) Long id) {
		return transportMetier.deleteTransport(id);
	}

}
