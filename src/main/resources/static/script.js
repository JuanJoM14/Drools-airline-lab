document.getElementById("flightForm").addEventListener("submit", function (e) {
    e.preventDefault();
    const form = e.target;
    const data = {
    passenger: {
        name: form.name.value,
        age: parseInt(form.age.value),
        membershipStatus: form.membershipStatus.value,
        travelingWithChildren: form.travelingWithChildren.value === "true",
        seatPreference: form.seatPreference.value,
        loyaltyPoints: parseInt(form.loyaltyPoints.value)
    },
    flight: {
        flightNumber: form.flightNumber.value,
        durationHours: parseFloat(form.durationHours.value),
        delayed: form.delayed.value === "true",
        emergencySeatsAvailable: form.emergencySeatsAvailable.value === "true"
    },
    luggage: {
        weightKg: parseFloat(form.weightKg.value)
    }
    };
    // Enviar al backend
    fetch("http://localhost:8080/api/bookings/evaluate", {
    method: "POST",
    headers: {
        "Content-Type": "application/json"
    },
    body: JSON.stringify(data)
    })
    .then(response => {
        if (!response.ok) {
        throw new Error("Error en la solicitud al backend");
        }
        return response.json();
    })
    .then(result => {
        const output = document.getElementById("output");
        output.innerHTML = `
        <h2>Resultado del Análisis</h2>
        <ul>
            <li><strong>Clase ejecutiva:</strong> ${result.upgradedToBusinessClass ? "Sí" : "No"}</li>
            <li><strong>Check-In prioritario:</strong> ${result.priorityCheckIn ? "Sí" : "No"}</li>
            <li><strong>Descuento aplicado:</strong> ${result.discountPercentage}%</li>
            <li><strong>Elegible para mejora:</strong> ${result.eligibleForUpgrade ? "Sí" : "No"}</li>
            <li><strong>Asiento de emergencia asignado:</strong> ${result.assignedEmergencyExitSeat ? "Sí" : "No"}</li>
            <li><strong>Compensación económica:</strong> $${result.compensationAmount.toFixed(2)}</li>
            <li><strong>Puntos extra de fidelidad:</strong> ${result.extraLoyaltyPoints}</li>
            <li><strong>Equipaje restringido:</strong> ${result.luggageRestricted ? "Sí" : "No"}</li>
            <li><strong>Acceso VIP Lounge:</strong> ${result.vipLoungeAccess ? "Sí" : "No"}</li>
            <li><strong>Asiento preferencial para familia:</strong> ${result.familyPreferentialSeat ? "Sí" : "No"}</li>
            <li><strong>Mensaje del sistema:</strong> <em>${result.message}</em></li>
        </ul>
        `;
    })
    .catch(error => {
        document.getElementById("output").textContent = "Error: " + error.message;
        console.error("Error al enviar los datos:", error);
    });
});
