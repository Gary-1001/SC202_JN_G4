package com.mycompany.proyecto1;

public class Reserva {
    
    Habitacion habitacion;
    Cliente cliente;

    public Reserva(Habitacion habitacion, Cliente cliente) {
        this.habitacion = habitacion;
        this.cliente = cliente;
        habitacion.disponible = false;
    }

    public String toString() {
        return cliente.nombre + " → Hab #" + habitacion.id;
    }
}


