package com.mycompany.proyecto1;
public class Cliente {
    
    String nombre;
    String cedula;

    public Cliente(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }

    public String toString() {
        return nombre + " (Cédula: " + cedula + ")";
    }
}

