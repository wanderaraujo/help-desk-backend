package com.araujo.helpdesk.enums;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.araujo.helpdesk.entity.ChangeStatus;

public interface ChangeStatusRepository extends MongoRepository<ChangeStatus, String>{
	
	Iterable<ChangeStatus> findByTicketIdOrderByUpdatedAtDesc(String ticketId);
}
