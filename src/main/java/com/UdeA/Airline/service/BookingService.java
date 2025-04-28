package com.UdeA.Airline.service;

import com.UdeA.Airline.model.BookingResponse;
import com.UdeA.Airline.model.Flight;
import com.UdeA.Airline.model.Luggage;
import com.UdeA.Airline.model.Passenger;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private KieContainer kieContainer;

    public BookingResponse evaluateBooking(Passenger passenger, Flight flight, Luggage luggage) {
        BookingResponse response = new BookingResponse();

        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(passenger);
        kieSession.insert(flight);
        kieSession.insert(luggage);
        kieSession.insert(response);

        kieSession.fireAllRules();
        kieSession.dispose();

        return response;
    }
}
