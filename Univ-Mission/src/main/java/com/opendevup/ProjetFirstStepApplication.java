package com.opendevup;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.opendevup.dao.EtatsRepository;
import com.opendevup.dao.MissionRepository;
import com.opendevup.dao.MissionnaireRepository;
import com.opendevup.dao.NotificationRepository;
import com.opendevup.entities.EtatsMission;
import com.opendevup.entities.Mission;
import com.opendevup.entities.Missionnaire;
import com.opendevup.entities.Notification;
import com.opendevup.entities.Remboursement;
import com.opendevup.entities.Transport;
import com.opendevup.model.FileStorageProperties;


@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class ProjetFirstStepApplication implements CommandLineRunner {

    @Value( "${dir.images}" )
    private String                 imageDir;

    @Autowired
    private MissionRepository      missionRepository;

    @Autowired
    private MissionnaireRepository missionnaireRepository;

    @Autowired
    private EtatsRepository        etatsRepository;

    @Autowired
    private NotificationRepository notificationRepository;
    


    public static void main( String[] args ) {
        SpringApplication.run( ProjetFirstStepApplication.class, args );
    }

    @Override
    public void run( String... arg0 ) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy/MM/dd" );

        Missionnaire m1 = new Missionnaire( "Missionnaire", "Canalda",
                "Philippe", "12345 5864 7854 51",
                "missionnaireSTGI@gmail.com", "password",
                "Besancon", "Montbeliard", "Enseignant",
                "Professeur", formatter.parse( "1967/01/01" ), "0758328274",
                "Multimedia",
                "UFR STGI", "Femto-ST" );
        m1.setEtatInscription( true );
        Missionnaire m2 = new Missionnaire( "Missionnaire", "GUEYE",
                "Ousmane", "107533051",
                "missionnaireIUT@gmail.com", "password",
                "Besancon", "Belfort", "Etudiant",
                "Professeur", formatter.parse( "1992/01/01" ), "0758328274",
                "MMI",
                "IUT Belfort Montbeliard" ,"Femto-ST" );
        m2.setEtatInscription( true );

        Missionnaire gmm = new Missionnaire( "GestionnaireSTGI", "Laetitia", "Vacheresse", "12345 5864 7854 51",
                "gestionnaireSTGI@gmail.com", "password", "Besancon", "Montbeliard", "Secrétaire", "Scolarité",
                formatter.parse( "1972/01/01" ), "0758328274", "Multimedia", "UFR STGI", "" );
     //   m2.setEtatInscription( true );

        Missionnaire rmm = new Missionnaire( "ResponsableMM", "Mostafoui",
                "Ahmed", "12345 5864 7854 51",
                "responsableMM@gmail.com", "password",
                "Besancon", "Montbeliard", "Responsable",
                "Enseignant", formatter.parse( "1972/01/01" ), "0758328274",
                "Multimedia",
                "UFR STGI", "");

        Missionnaire dmm = new Missionnaire( "DirecteurSTGI", "Jouffroy",
                "Olivier", "12345 5864 7854 51",
                "directeurSTGI@gmail.com", "password",
                "Besancon", "Montbeliard", "Directeur",
                "Directeur", formatter.parse( "1972/01/01" ), "0758328274",
                "Multimedia",
                "UFR STGI", "" );

        
        Missionnaire gmmi = new Missionnaire( "GestionnaireIUT", "Christelle", "block", "12345 5864 7854 51",
                "gestionnaireIUT@gmail.com", "password", "Besancon", "Montbeliard", "Secrétaire", "Scolarité",
                formatter.parse( "1972/01/01" ), "0758328274", "MMI", "IUT Belfort-Montbeliard", "" );
       // m2.setEtatInscription( true );
        
        
        Missionnaire rmmi = new Missionnaire( "ResponsableMMI", "Chatonnay",
                "Pascal", "12345 5864 7854 51",
                "responsableMMI@gmail.com", "password",
                "Besancon", "Montbeliard", "Responsable",
                "Enseignant", formatter.parse( "1972/01/01" ), "0758328274",
                "MMI",
                "IUT Belfort-Montbeliard", "" );

        Missionnaire dmmi = new Missionnaire( "DirecteurIUT", "Viezzi",
                "Bruno", "12345 5864 7854 51",
                "directeurIUT@gmail.com", "password",
                "Besancon", "Montbeliard", "Directeur",
                "Directeur", formatter.parse( "1972/01/01" ), "0758328274",
                "MMI",
                "IUT Belfort-Montbeliard", "" );

        Missionnaire p = new Missionnaire( "PresidentUFC", "Bahi",
                "Jacque", "12345 5864 7854 51",
                "president@gmail.com", "password",
                "Besancon", "Montbeliard", "President",
                "Directeur UFC", formatter.parse( "1972/01/01" ), "0758328274",
                "UFC",
                "UFC", "" );
        Missionnaire gfmto = new Missionnaire( "GestionnaireFEMTO", "Eugen", "Dedu", "12345 5864 7854 51",
                "gestionnaireFEMTO@gmail.com", "password", "Besancon", "Montbeliard", "Secrétaire", "Scolarité",
                formatter.parse( "1972/01/01" ), "0758328274", "Montbéliard", " DESC", "" );
        
        Missionnaire rfmto = new Missionnaire( "ResponsableFEMTO", "Eugen", "Dedu", "12345 5864 7854 51",
                "responsableFEMTO@gmail.com", "password", "Besancon", "Montbeliard", "Secrétaire", "Scolarité",
                formatter.parse( "1972/01/01" ), "0758328274", "Montbéliard", " DESC", "" );
       // m2.setEtatInscription( true );

        missionnaireRepository.save( m1 );
        missionnaireRepository.save( m2 );
        missionnaireRepository.save( gmm );
        missionnaireRepository.save( rmm );
        missionnaireRepository.save( dmm );
        
        missionnaireRepository.save( gmmi );
        missionnaireRepository.save( rmmi );
        missionnaireRepository.save( dmmi );
        missionnaireRepository.save( p );
        missionnaireRepository.save(gfmto);
        missionnaireRepository.save(rfmto);

         /* Notification ntf = new Notification( "Canalda", "Philippe", "Veuillez accepter ma demande de mission", "Il y'a environ 5 minutes" );
         ntf.setMissionnaire_fk( m1 );
         Notification ntf2 = new Notification( "Logdali", "Souhail", "Veuillez accepter ma demande de mission",
         "Il y'a environ 5 minutes" );
        ntf2.setMissionnaire_fk( m2 );
        notificationRepository.save( ntf );
        notificationRepository.save( ntf2 );*/
        //
        Mission ms = new Mission( true, formatter.parse( "2018/02/23" ),"Mission Pédagogique", "UE", "Belfort", "France",
            formatter.parse( "2018/02/25" ), formatter.parse( "2018/03/31" ), "Mission Pédagogique", true );
        // Mission ms2 = new Mission( true, formatter.parse( "2018/04/23" ),
        // "Paris", "France",
        // formatter.parse( "2018/04/25" ), formatter.parse( "2018/05/31" ),
        // "Mission pédagogique", true );
        //
       // Mission ms = new Mission( true, "Mission Pédagogique", formatter.parse( "2018/02/23" ), "UE", "Belfort", "France",
       //         formatter.parse( "2018/02/25" ), formatter.parse( "2018/03/31" ), "Mission Pédagogique", true, m1 );
       
      
          ms.setMissionnaire_fk( m1 );
        // ms2.setMissionnaire_fk( m1 );
        //
       missionRepository.save( ms );
        // missionRepository.save( ms2 );
        //
       	etatsRepository.save( new EtatsMission( ms.getIdMission(), "validée", "GestionnaireSTGI" ) );
        etatsRepository.save( new EtatsMission( ms.getIdMission(), "validée", "ResponsableMM" ) );
       // etatsRepository.save( new EtatsMission( ms.getIdMission(), "valide", "DirecteurSTGI" ) );
       // etatsRepository.save( new EtatsMission( ms.getIdMission(), "", "DirecteurMM" ) );
        //
        // etatsRepository.save( new EtatsMission( ms2.getIdMission(), "en
        // cours", "Gestionnaire" ) );
        // etatsRepository.save( new EtatsMission( ms2.getIdMission(), "en
        // cours", "Responsable" ) );
        // etatsRepository.save( new EtatsMission( ms2.getIdMission(), "en
        // cours", "Directeur" ) );
         etatsRepository.save( new EtatsMission( ms.getIdMission(), 
         "valide", "DirecteurSTGI" ) );

        // missionRepository.findAll().forEach( m -> {
        // System.out.println( "voici la date de départ: " + m.getDateDepart()
        // );
        // } );
        
     
       
    }
}
