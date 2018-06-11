package com.opendevup.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.opendevup.entities.Missionnaire;
import com.opendevup.entities.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    @Query( "SELECT n from Notification n where n.missionnaire_fk=:x" )
    public List<Notification> chercherNotifications( @Param( "x" ) Missionnaire ms );

}
