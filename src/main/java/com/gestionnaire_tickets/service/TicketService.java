package com.gestionnaire_tickets.service;

import com.gestionnaire_tickets.model.Ticket;
import com.gestionnaire_tickets.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Optional<Ticket> getTicketById(Long id) {
        return ticketRepository.findById(id);
    }

    public Ticket saveTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public Ticket updateTicket(Long id, Ticket ticketDetails) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket non trouvé avec l'id : " + id));
        
        ticket.setTitre(ticketDetails.getTitre());
        ticket.setDescription(ticketDetails.getDescription());
        ticket.setStatut(ticketDetails.getStatut());
        ticket.setDateDeCreation(ticketDetails.getDateDeCreation());
        ticket.setUtilisateur(ticketDetails.getUtilisateur());
        
        final Ticket updatedTicket = ticketRepository.save(ticket);
        return updatedTicket;
    }

    public void deleteTicket(Long id) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket non trouvé avec l'id : " + id));
        ticketRepository.delete(ticket);
    }
}
