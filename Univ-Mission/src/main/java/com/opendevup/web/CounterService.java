package com.opendevup.web;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.opendevup.dao.MessageRepository;
import com.opendevup.dao.MissionnaireRepository;
import com.opendevup.dao.NotificationRepository;
import com.opendevup.entities.Message;
import com.opendevup.entities.Notification;
import com.opendevup.hundler.CounterHandler;
import com.opendevup.hundler.CounterHandlerMsg;
import com.opendevup.metier.MessageMetierImpl;

@Component
public class CounterService {

    private AtomicInteger  counter = new AtomicInteger( 0 );

    @Autowired
    NotificationRepository notificationRepository;

    @Autowired
    MissionnaireRepository missionnaireRepository;
    @Autowired
    MessageRepository messageRepository;

    @Autowired
    CounterHandler         counterHandler;
    @Autowired
    CounterHandlerMsg         counterHandlerMsg;

    @Scheduled( fixedDelay = 5000 )
    public void sendCounterUpdate() {
        // System.out.println( "voici le travail: " +
        // MissionRestService.insertion + " " + MissionRestService.a );
        // if ( MissionRestService.insertion == 1 ||
        // MissionRestService.hasChangedValue( MissionRestService.a ) ) {
        // MissionRestService.insertion = 0;
    	System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    	System.out.println(ConnexionRestService.a);
    	System.out.println(MessageMetierImpl.a);
        System.out.println(notificationRepository
                .chercherNotifications( missionnaireRepository.findOne( ConnexionRestService.a ) ));
        if(messageRepository.findOne(MessageRestImpl.a)!=null)
        	System.out.println(messageRepository.findOne(MessageRestImpl.a).getMessage());
    	
        List<Notification> ntfs = new ArrayList<Notification>();
        ntfs = notificationRepository
                .chercherNotifications( missionnaireRepository.findOne( ConnexionRestService.a ) );
        counterHandler.counterIncrementedCallback( ntfs );
        List<Message> msg = new ArrayList<Message>();
        msg = messageRepository.ChercherMessage( MessageMetierImpl.a ) ;
        counterHandlerMsg.counterIncrementedCallback( msg );
        // }
      
    }

    Integer getValue() {
        return counter.get();
    }
}