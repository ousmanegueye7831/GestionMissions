package com.opendevup.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.opendevup.entities.Transport;

public interface TransportRepository extends JpaRepository<Transport, Long> {

}
