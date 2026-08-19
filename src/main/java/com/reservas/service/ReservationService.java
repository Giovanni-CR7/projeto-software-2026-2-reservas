package com.reservas.service;

import com.reservas.entity.Event;
import com.reservas.entity.Payment;
import com.reservas.entity.Reservation;
import com.reservas.entity.Ticket;
import com.reservas.repository.PaymentRepository;
import com.reservas.repository.ReservationRepository;
import com.reservas.repository.TicketRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final PaymentRepository paymentRepository;
    private final TicketRepository ticketRepository;

    public ReservationService(ReservationRepository reservationRepository,
                              PaymentRepository paymentRepository,
                              TicketRepository ticketRepository) {
        this.reservationRepository = reservationRepository;
        this.paymentRepository = paymentRepository;
        this.ticketRepository = ticketRepository;
    }

    @Transactional
    public Reservation createReservation(Event event, String cpf) {
        // Verifica se há ingressos disponíveis
        if (event.getAvailableTickets() <= 0) {
            throw new IllegalArgumentException("Não há ingressos disponíveis");
        }

        // Cria a reserva
        Reservation reservation = new Reservation(event, cpf);
        Reservation savedReservation = reservationRepository.save(reservation);

        // Diminui a quantidade de ingressos disponíveis
        event.setAvailableTickets(event.getAvailableTickets() - 1);

        return savedReservation;
    }

    @Transactional
    public void confirmReservation(Long reservationId, Payment.PaymentType paymentType, String paymentData) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new IllegalArgumentException("Reserva não encontrada"));

        if (reservation.getStatus() != Reservation.ReservationStatus.PENDING) {
            throw new IllegalArgumentException("Reserva não está pendente");
        }

        // Cria o pagamento
        Payment payment = new Payment(reservation, paymentType, paymentData);
        payment.setStatus(Payment.PaymentStatus.APPROVED);
        paymentRepository.save(payment);

        // Atualiza o status da reserva
        reservation.setStatus(Reservation.ReservationStatus.CONFIRMED);
        reservation.setPayment(payment);
        reservationRepository.save(reservation);

        // Cria o ticket confirmado
        Event event = reservation.getEvent();
        Ticket ticket = new Ticket(
                reservation,
                reservation.getCpf(),
                event.getName(),
                event.getEventDate(),
                event.getPrice()
        );
        ticketRepository.save(ticket);
    }

    public Reservation getReservationById(Long reservationId) {
        return reservationRepository.findById(reservationId)
                .orElseThrow(() -> new IllegalArgumentException("Reserva não encontrada"));
    }
}
