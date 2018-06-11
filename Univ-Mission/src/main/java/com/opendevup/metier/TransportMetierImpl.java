package com.opendevup.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opendevup.dao.TransportRepository;
import com.opendevup.entities.Transport;

@Service
public class TransportMetierImpl implements TransportMetier{
	@Autowired
	private TransportRepository transportRepository;
	@Override
	public Transport saveTransport(Transport t) {
		// TODO Auto-generated method stub
		return transportRepository.save(t);
	}

	@Override
	public Transport getTransport(Long id) {
		// TODO Auto-generated method stub
		return  transportRepository.findOne( id );
	}

	@Override
	public Boolean deleteTransport(Long id) {
		// TODO Auto-generated method stub
		transportRepository.delete( id );
		return true;
	}

}
