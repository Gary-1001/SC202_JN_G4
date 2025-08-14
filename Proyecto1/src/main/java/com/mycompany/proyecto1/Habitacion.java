package com.mycompany.proyecto1;
public class Habitacion {
    
    int id;
    String tipo;
    boolean disponible;

    public Habitacion(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
        this.disponible = true;
    }

    public String toString() {
        return "Habitacion #" + id + " - Tipo: " + tipo + " - " + (disponible ? "Disponible" : "Reservada");
    }
}

 
