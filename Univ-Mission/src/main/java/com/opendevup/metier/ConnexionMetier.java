package com.opendevup.metier;

import javax.servlet.http.HttpServletRequest;


import com.opendevup.entities.Missionnaire;

public interface ConnexionMetier {
	public Missionnaire connexion( HttpServletRequest request, Missionnaire m );
}
