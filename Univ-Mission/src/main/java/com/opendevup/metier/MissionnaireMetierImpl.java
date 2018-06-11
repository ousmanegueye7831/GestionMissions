package com.opendevup.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opendevup.dao.MissionRepository;
import com.opendevup.dao.MissionnaireRepository;
import com.opendevup.entities.Mission;
import com.opendevup.entities.Missionnaire;

@Service
public class MissionnaireMetierImpl implements MissionnaireMetier{
	
	@Autowired
	private MissionnaireRepository missionnaireRepository;
	private MissionRepository missionRepository;

	@Override
	public List<Missionnaire> listeMissionnaires() {
		// TODO Auto-generated method stub
		return missionnaireRepository.findAll();
	}

	@Override
	public Missionnaire getMissionnaire(Missionnaire m) {
		// TODO Auto-generated method stub
		
		
		//m.setMissionnaire_fk(missionRepository.findOne(m.getIdMission()).getMissionnaire_fk());
		System.out.println("---------------"+m.getIdMissionnaire());
	
		//System.out.println("getMissionnaire------------------------"+ mis.getDestination());
		return missionnaireRepository.findOne(m.getIdMissionnaire());
	}

	@Override
	public Missionnaire saveMissionnaire(Missionnaire m) {
		// TODO Auto-generated method stub
		return missionnaireRepository.save(m);
	}

	@Override
	public Boolean deleteMissionnaire(Long id) {
		// TODO Auto-generated method stub
		missionnaireRepository.delete(id);;
		return true;
	}

	@Override
	public Missionnaire updateMissionnaire(Long id, Missionnaire m) {
		// TODO Auto-generated method stub
		m.setIdMissionnaire( id );
		return missionnaireRepository.save(m);
	}

	@Override
	public Missionnaire updateMissionnaire(Missionnaire m) {
        m.setTypeMissionnaire( "Missionnaire" );
        if ( missionnaireRepository.validerMissionnaire( m.getAffectation(), m.getAnniversaire(),
                m.getDepartement(),
                m.getGrade(),
                m.getEtablissement(), m.getLaboratoire(), m.getNumeroTel(), m.getResidenceAdministrative(),
                m.getResidencePersonnelle(), m.getSecuriteSocial(), m.getTypeMissionnaire(),
                m.getIdMissionnaire() ) == 1 ) {
            Missionnaire ms = missionnaireRepository.findOne( m.getIdMissionnaire() );
            return ms;
        } else
            return null;
	}



}
