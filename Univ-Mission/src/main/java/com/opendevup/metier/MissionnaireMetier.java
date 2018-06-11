package com.opendevup.metier;

import java.util.List;

import com.opendevup.entities.Mission;
import com.opendevup.entities.Missionnaire;

public interface MissionnaireMetier {
	public List<Missionnaire> listeMissionnaires(); //List
	public Missionnaire getMissionnaire( Missionnaire m );
	public Missionnaire saveMissionnaire(Missionnaire m );  //save
	public Boolean deleteMissionnaire( Long id );  //daleteMissionaire
	public Missionnaire updateMissionnaire( Long id,  Missionnaire m );
	public Missionnaire updateMissionnaire( Missionnaire m );

}
