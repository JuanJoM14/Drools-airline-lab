package com.UdeA.Airline.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Passenger {

    private String name;                    // Nombre del pasajero
    private int age;                        // Edad del pasajero
    private String membershipStatus;        // Nivel de membresía: Basic, Gold, Platinum
    private boolean travelingWithChildren;  // Indica si viaja con niños
    private String seatPreference;          // Preferencia de asiento: Window, Aisle, Any
    private int loyaltyPoints;              // Puntos de lealtad acumulados
}