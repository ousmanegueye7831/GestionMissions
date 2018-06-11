package com.opendevup.metier;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opendevup.dao.DepenseRepository;
import com.opendevup.dao.DeplacementRepository;
import com.opendevup.dao.EtatsRepository;
import com.opendevup.dao.MissionRepository;
import com.opendevup.dao.MissionnaireRepository;
import com.opendevup.entities.Depense;
import com.opendevup.entities.Deplacement;
import com.opendevup.entities.EtatsMission;
import com.opendevup.entities.Mission;
import com.opendevup.services.entities.MultipleDeplacementDepense;

@Service
public class RemboursementMetierImpl implements RemboursementMetier{
	@Autowired
	private MissionRepository missionRepository;
	@Autowired
	private DepenseRepository depenseRepository;
	@Autowired
	private DeplacementRepository deplacementRepository;
	@Autowired
	private EtatsRepository etatsRepository;
	@Autowired
	private MissionnaireRepository missionnaireRepository;
	@Override
	public List<Mission> listeMissionCourant( Long id) {
		 List<EtatsMission> etats = new ArrayList<EtatsMission>();
	     List<Mission> missions = new ArrayList<Mission>();
	     System.out.println("test"+ id);
	     etats = etatsRepository.chercherMissionARemb( "en cours",
	     missionnaireRepository.findOne( id ).getTypeMissionnaire() );
	   
	     for ( int i = 0; i < etats.size(); i++ )
	         missions.add( missionRepository.findOne( etats.get( i ).getIdmission() ) );
	      return missions;
	}
	@Override
	public MultipleDeplacementDepense listeRemb(Mission m) {
		// TODO Auto-generated method stub
		MultipleDeplacementDepense dd= new MultipleDeplacementDepense();
		List<Deplacement> deplacement= new ArrayList<Deplacement>();
		List<Depense> depense= new ArrayList<Depense>();
		for(int i=0; i<deplacementRepository.chercherDeplacement(m).size(); i++) {
			deplacement.add(deplacementRepository.findOne(deplacementRepository.chercherDeplacement(m).get(i).getIdDeplacement()));
		}
		for(int i=0; i<depenseRepository.chercherDepense(m).size(); i++) {
			depense.add(depenseRepository.findOne(depenseRepository.chercherDepense(m).get(i).getIdDepense()));
		}
		dd.setIdMission(m.getIdMission());
		dd.setDeplacement(deplacement);
		dd.setDepense(depense);
		
		return dd;
	}
	


}
