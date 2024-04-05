package com.gestionnaire_tickets.repository;

import com.gestionnaire_tickets.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
