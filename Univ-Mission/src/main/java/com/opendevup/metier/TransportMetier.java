package com.opendevup.metier;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.opendevup.entities.Transport;

public interface TransportMetier {
	  public Transport saveTransport( Transport t );
	  public Transport getTransport( Long id );
	  public Boolean deleteTransport( Long id );
}

