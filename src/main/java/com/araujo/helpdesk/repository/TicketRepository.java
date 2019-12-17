package com.araujo.helpdesk.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.araujo.helpdesk.entity.Ticket;

public interface TicketRepository extends MongoRepository<Ticket, String> {

	Page<Ticket> findByUserIdOrderByCreatedAtDesc(Pageable pages, String userId);
	
	Page<Ticket> findByTitleContainingIgnoreCaseAndStatusAndPriorityOrderByCreatedAt(
			Pageable pages, String title, String status, String priority);
	
	Page<Ticket> findByTitleIgnoreCaseContainingAndStatusAndPriorityAndUserIdOrderByCreatedAtDesc(
			Pageable pages, String title, String status, String priority, String userId);
	
	Page<Ticket> findByTitleContainingIgnoreCaseAndStatusAndPriorityAndAssinedUserIdOrderByCreatedAt(
			Pageable pages, String title, String status, String priority, String assignedUserId );
	
	Page<Ticket> findByNumber(Pageable pages, Integer number);
	
}
