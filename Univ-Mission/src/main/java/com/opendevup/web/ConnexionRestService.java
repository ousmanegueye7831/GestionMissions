package com.opendevup.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.opendevup.dao.MissionnaireRepository;
import com.opendevup.entities.Missionnaire;


@RestController
@CrossOrigin( "*" )
public class ConnexionRestService {
    public static Long a         = 0L;
    public static Long b         = 0L;
    public static int  insertion = 0;

    public static boolean hasChangedValue( Long temp ) {
        if ( b != a ) {
            b = a;
            return true;
        }
        return false;
    }
	
	@Autowired
	private MissionnaireRepository missionnaireRepository;
	
    @RequestMapping( value = "/Connexion", method = RequestMethod.POST )
    public Missionnaire connexion( HttpServletRequest request, @RequestBody Missionnaire m ) {
        int j = 0;
        Missionnaire ms = missionnaireRepository.chercherMissionnaire( m.getLogin(), m.getPassword() );
        request.getSession().setAttribute( "missionnaire", ms );
        a = ms.getIdMissionnaire();
        // System.out.println( "VOICIIII LE A: " + a );
        insertion = 1;
        return ms;

    }
}	
