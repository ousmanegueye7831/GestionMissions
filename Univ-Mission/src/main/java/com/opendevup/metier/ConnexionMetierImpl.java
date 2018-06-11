package com.opendevup.metier;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opendevup.dao.MissionnaireRepository;
import com.opendevup.entities.Missionnaire;

@Service
public class ConnexionMetierImpl implements ConnexionMetier {
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

	@Override
	public Missionnaire connexion(HttpServletRequest request, Missionnaire m) {
		// TODO Auto-generated method stub
		int j = 0;
	    Missionnaire ms = missionnaireRepository.chercherMissionnaire( m.getLogin(), m.getPassword() );
	    request.getSession().setAttribute( "missionnaire", ms );
	    a = ms.getIdMissionnaire();
	    // System.out.println( "VOICIIII LE A: " + a );
	    insertion = 1;
	    return ms;
	}

}
