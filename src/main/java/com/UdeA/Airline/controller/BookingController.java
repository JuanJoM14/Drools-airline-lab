package com.UdeA.Airline.controller;

import com.UdeA.Airline.model.BookingResponse;
import com.UdeA.Airline.model.Flight;
import com.UdeA.Airline.model.Luggage;
import com.UdeA.Airline.model.Passenger;
import com.UdeA.Airline.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://127.0.0.1:8080")
@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/evaluate")
    public BookingResponse evaluateBooking(@RequestBody BookingRequest request) {
        return bookingService.evaluateBooking(request.getPassenger(), request.getFlight(), request.getLuggage());
    }

    // Clase interna para manejar la solicitud JSON
    public static class BookingRequest {
        private Passenger passenger;
        private Flight flight;
        private Luggage luggage;

        // Getters y Setters
        public Passenger getPassenger() { return passenger; }
        public void setPassenger(Passenger passenger) { this.passenger = passenger; }

        public Flight getFlight() { return flight; }
        public void setFlight(Flight flight) { this.flight = flight; }

        public Luggage getLuggage() { return luggage; }
        public void setLuggage(Luggage luggage) { this.luggage = luggage; }
    }
}
