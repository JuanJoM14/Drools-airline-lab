package com.UdeA.Airline.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingResponse {
    private boolean upgradedToBusinessClass;  // Indica si el pasajero fue ascendido a clase ejecutiva
    private boolean priorityCheckIn;          // Acceso a check-in prioritario
    private double discountPercentage;        // Porcentaje de descuento aplicado por equipaje liviano
    private boolean eligibleForUpgrade;       // Si el pasajero es elegible para upgrades
    private boolean assignedEmergencyExitSeat; // Si fue asignado a un asiento de salida de emergencia
    private double compensationAmount;        // Monto de compensación por retrasos extremos
    private int extraLoyaltyPoints;           // Puntos de lealtad adicionales otorgados
    private boolean luggageRestricted;        // Indica si el equipaje fue restringido
    private boolean vipLoungeAccess;          // Acceso otorgado al salón VIP
    private boolean familyPreferentialSeat;   // Si se asignó asiento preferencial por viajar en familia
    private String message;                   // Mensaje resumen de los beneficios aplicados
}