package com.opendevup.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opendevup.dao.EtatsRepository;
import com.opendevup.dao.MissionRepository;
import com.opendevup.dao.MissionnaireRepository;
import com.opendevup.dao.NotificationRepository;
import com.opendevup.entities.EtatsMission;
import com.opendevup.entities.Mission;
import com.opendevup.entities.Missionnaire;
import com.opendevup.entities.Notification;
import com.opendevup.services.entities.MultipleMissionnaireMission;

@Service
public class NotificationMetierImpl implements NotificationMetier{
	
	@Autowired
	private NotificationRepository notificationRepository;
	@Autowired
	private MissionnaireRepository missionnaireRepository;
	@Autowired
	private MissionRepository missionRepository;
	@Autowired
	private EtatsRepository etatsRepository;
    public static int  insertion = 0;
	@Override
	public List<Notification> listeNotifications(Missionnaire ms) {
		// TODO Auto-generated method stub
		return notificationRepository.chercherNotifications(ms);
	}

	@Override
	public Notification saveNotification(MultipleMissionnaireMission m) {
        m.getMission().setMissionnaire_fk( m.getMissionnaire() );

        m.getNotification().setNom( m.getMissionnaire().getNom() );
        m.getNotification().setPrenom( m.getMissionnaire().getPrenom() );
        m.getNotification().setMessage( "veuillez Accepter ma demande de mission, Cordialement." );
        m.getNotification().setDateDemande( "Il y'a environ 5 min." );
        m.getNotification().setMissionnaire_fk( missionnaireRepository.chercherMissionnaire( "GestionnaireSTGI" ) );

        notificationRepository.save( m.getNotification() );

        Notification ntf = new Notification( missionnaireRepository.chercherMissionnaire( "GestionnaireSTGI" ).getNom(),
                missionnaireRepository.chercherMissionnaire( "GestionnaireSTGI" ).getPrenom(),
                "Votre demande est en cours de traitement", "Il y'a environ 2 sec" );
        ntf.setMissionnaire_fk( m.getMissionnaire() );
        notificationRepository.save( ntf );

        Mission ms = missionRepository.save( m.getMission() );

        etatsRepository.save( new EtatsMission( ms.getIdMission(), "en cours", "GestionnaireMM" ) );
        etatsRepository.save( new EtatsMission( ms.getIdMission(), "", "ResponsableMM" ) );
        etatsRepository.save( new EtatsMission( ms.getIdMission(), "", "DirecteurMM" ) );
        etatsRepository.save( new EtatsMission( ms.getIdMission(), "", "President" ) );
      

        insertion = 1;

        return ntf;
	}

}
