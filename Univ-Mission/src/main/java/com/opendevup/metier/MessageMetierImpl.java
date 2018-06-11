package com.opendevup.metier;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opendevup.dao.MessageRepository;
import com.opendevup.dao.MissionRepository;
import com.opendevup.dao.MissionnaireRepository;
import com.opendevup.entities.Message;
import com.opendevup.entities.Mission;
import com.opendevup.services.entities.MultipleMessageMission;
import com.opendevup.util.NotificationMessage;



@Service
public class MessageMetierImpl implements MessageMetier {
	public static Long a         = 0L;
	@Autowired
	private MessageRepository messageRepository;
	@Autowired
	private MissionRepository missionRepository;
	@Autowired
	private MissionnaireRepository missionnaireRepository;
    @Autowired
    private NotificationMessage notificationMessage;
    
	@Override
	public boolean saveMessage( MultipleMessageMission msg ) {
		// TODO Auto-generated method stub
        // System.out.println( "vvvvvvoiiiiiiiiila le travail: " +
        // msg.getMission().getDestination() + " et: "
        // + msg.getMission().getMissionnaire_fk().toString() );
	//	m.setMissionnaire_fk( m.getMissionnaire_fk());
		a = missionRepository.findOne(msg.getIdMission()).getMissionnaire_fk().getIdMissionnaire();
		System.out.println("aaaaaaaaaaaaaaa "+a);
		msg.getMessage().setIdMission(msg.getIdMission());
		//msg.getMessage().setIdDestinataire(msg.getDestinataire());
		System.out.println("MEEEESSAGEEE "+ msg.getMessage().getNom()
				 +msg.getIdMission());
//       msg.getMessage().setMissionnaire_fk(
//        missionRepository.findOne( msg.getMission().getIdMission() ).getMissionnaire_fk() );
        messageRepository.save( msg.getMessage() );
        String message = msg.getMessage().getMessage();
        System.out.println(message);
        try {
			//String from = missionnaireRepository.chercherMissionnaire( "GestionnaireSTGI" ).getLogin();
			//System.out.println(from);
			String sms = "Bonjour "+ missionRepository.findOne( msg.getMessage().getIdMission()).getMissionnaire_fk().getNom() + ",\n\n"+  message + "\n\n Cordialement \n\n"+ msg.getMessage().getPrenom() +" "+ msg.getMessage().getNom() +".";
			notificationMessage.sendMail("ousmanegueye7831@gmail.com", "Demande Mission", sms);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return true;
	}
	
}
