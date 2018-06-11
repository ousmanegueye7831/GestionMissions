package com.opendevup.hundler;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.opendevup.entities.Message;
import com.opendevup.entities.Notification;

@Component
public class CounterHandler extends TextWebSocketHandler {

    WebSocketSession session;

    // This will send only to one client(most recently connected)
    public void counterIncrementedCallback( List<Notification> ntfs ) {
        // System.out.println( "Trying to send:" + ntfs.size() );
        if ( session != null && session.isOpen() ) {
            try {
                for ( int i = 0; i < ntfs.size(); i++ ) {

                    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
                    String json = ow.writeValueAsString( ntfs.get( i ) );

                    // System.out.println( "Now sending:" + json );

                    session.sendMessage( new TextMessage( json ) );
                }
            } catch ( Exception e ) {
                e.printStackTrace();
            }
        } else {
            // System.out.println( "Don't have open session to send:" +
            // ntfs.size() );
        }
    }
    
    
    
/*    public void counterIncrementedCallback( Message msg ) {
        // System.out.println( "Trying to send:" + ntfs.size() );
        if ( session != null && session.isOpen() ) {
            try {
               // for ( int i = 0; i < ntfs.size(); i++ ) {

                    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
                    String json = ow.writeValueAsString( msg );

                    // System.out.println( "Now sending:" + json );

                    session.sendMessage( new TextMessage( json ) );
                //}
            } catch ( Exception e ) {
                e.printStackTrace();
            }
        } else {
            // System.out.println( "Don't have open session to send:" +
            // ntfs.size() );
        }
    }*/

    @Override
    public void afterConnectionEstablished( WebSocketSession session ) {
        System.out.println( "Connection established" );
        this.session = session;
    }

    @Override
    protected void handleTextMessage( WebSocketSession session, TextMessage message )
            throws Exception {
        if ( "CLOSE".equalsIgnoreCase( message.getPayload() ) ) {
            session.close();
        } else {
            System.out.println( "Received:" + message.getPayload() );
        }
    }

}
