package com.example.ticketmanager.controller;

import com.example.ticketmanager.model.Ticket;
import com.example.ticketmanager.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/user/{userId}")
    public List<Ticket> getTicketsByUserId(@PathVariable Long userId) {
        return ticketService.getTicketsByUserId(userId);
    }

    @PostMapping
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return ticketService.createTicket(ticket);
    }

    @PutMapping("/{id}")
    public Ticket updateTicket(@PathVariable Long id, @RequestBody Ticket ticketDetails) {
        return ticketService.updateTicket(id, ticketDetails);
    }
}
