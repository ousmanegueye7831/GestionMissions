package com.opendevup.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opendevup.dao.FicheJEFYCORepository;
import com.opendevup.entities.FicheJEFYCO;
import com.opendevup.services.entities.MultipleFicheMissionnaire;

@Service
public class FicheJEFYCOMetierImpl implements FicheJEFYCOMetier{
	
	@Autowired
	private FicheJEFYCORepository ficheJefycoRepository;

	@Override
	public FicheJEFYCO saveFicheJefyco(MultipleFicheMissionnaire fm) {
		// TODO Auto-generated method stub
		fm.getFiche().setMissionnaire( fm.getMissionnaire() );
		return ficheJefycoRepository.save(fm.getFiche());
	}

	@Override
	public List<FicheJEFYCO> listeFichesJEFYCO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FicheJEFYCO getFicheJEFYCO(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteFicheJEFYCO(Long id) {
		// TODO Auto-generated method stub
		return null;
	}	
	

}
