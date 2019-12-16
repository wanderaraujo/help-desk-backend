package com.araujo.helpdesk.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.araujo.helpdesk.entity.Ticket;

public interface TicketRepository extends MongoRepository<Ticket, String> {

	Page<Ticket> findByUserIdOrderByCreatedAtDesc(Pageable pages, String userId);
	
	Page<Ticket> findByTitleContainingIgnoreCaseAndStatusAndPriorityOrderByCreatedAt(
			Pageable pages, String title, String status, String priority);
	
	Page<Ticket> findByTitleContainingIgnoreCaseAndStatusAndAndUserIdOrderByCreatedAt(
			Pageable pages, String title, String status, String priority);
	
	Page<Ticket> findByTitleContainingIgnoreCaseAndStatusAndPriorityAndAssinedUserOrderByCreatedAt(
			Pageable pages, String title, String status, String priority);
	
	Page<Ticket> findByNumber(Pageable pages, Integer number);
	
}
