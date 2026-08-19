package com.reservas.service;

import com.reservas.dto.TicketResponse;
import com.reservas.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<TicketResponse> getTicketsByCpf(String cpf) {
        return ticketRepository.findByCpf(cpf)
                .stream()
                .map(ticket -> new TicketResponse(
                        ticket.getId(),
                        ticket.getCpf(),
                        ticket.getEventName(),
                        ticket.getEventDate(),
                        ticket.getPrice(),
                        ticket.getConfirmedAt()
                ))
                .collect(Collectors.toList());
    }
}
