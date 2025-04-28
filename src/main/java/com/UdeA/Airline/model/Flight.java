package com.UdeA.Airline.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flight {
    private String flightNumber;              // Número identificador del vuelo
    private double durationHours;             // Duración del vuelo en horas
    private boolean delayed;                  // Si el vuelo está retrasado
    private boolean emergencySeatsAvailable;  // Disponibilidad de asientos de emergencia
}