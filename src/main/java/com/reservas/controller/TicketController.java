package com.reservas.controller;

import com.reservas.dto.TicketResponse;
import com.reservas.service.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<List<TicketResponse>> getTicketsByCpf(@PathVariable String cpf) {
        List<TicketResponse> tickets = ticketService.getTicketsByCpf(cpf);
        return ResponseEntity.ok(tickets);
    }
}
