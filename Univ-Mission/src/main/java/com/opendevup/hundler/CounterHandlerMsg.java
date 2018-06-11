package com.opendevup.hundler;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.opendevup.entities.Message;

@Component
public class CounterHandlerMsg extends TextWebSocketHandler{
	WebSocketSession session;
	
	public void counterIncrementedCallback( List<Message> msg ) {
        // System.out.println( "Trying to send:" + ntfs.size() );
        if ( session != null && session.isOpen() ) {
            try {
                for ( int i = 0; i < msg.size(); i++ ) {

                    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
                    String json = ow.writeValueAsString( msg.get(i) );

                    // System.out.println( "Now sending:" + json );

                    session.sendMessage( new TextMessage( json ) );
                }
            } catch ( Exception e ) {
                e.printStackTrace();
            }
        } else {
             System.out.println( "Don't have open session to send:" +
             msg.size() );
        }
    }

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
