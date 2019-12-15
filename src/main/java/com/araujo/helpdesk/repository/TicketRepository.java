package com.araujo.helpdesk.repository;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.araujo.helpdesk.entity.Ticket;

public interface TicketRepository extends MongoRepository<Ticket, String> {

	Page<Ticket> findByUserIdOrderByCreatedAtDesc(Pageable pages, String userId);
	
	Page<Ticket> findByTitleContainingIgnoreCaseAndStatusContainingIgnoreCaseAndPriorityContainingIgnoreCaseOrderByCreatedAt(
			Pageable pages, String title, String status, String priority);
	
	Page<Ticket> findByTitleContainingIgnoreCaseAndStatusContainingIgnoreCaseAndPriorityContainingIgnoreCaseAndUserIdOrderByCreatedAt(
			Pageable pages, String title, String status, String priority);
	
	Page<Ticket> findByTitleContainingIgnoreCaseAndStatusContainingIgnoreCaseAndPriorityContainingIgnoreCaseAndAssinedUserOrderByCreatedAt(
			Pageable pages, String title, String status, String priority);
	
	Page<Ticket> findByNumber(Pageable pages, Integer number);
	
}
