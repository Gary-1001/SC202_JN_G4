package com.mycompany.proyecto1;

import javax.swing.JOptionPane;
public class Proyecto1 {

    static Habitacion hab1 = null, hab2 = null, hab3 = null;
    static Cliente cli1 = null, cli2 = null, cli3 = null;
    static Reserva res1 = null, res2 = null, res3 = null;

    public static void main(String[] args) {
        int opcion;

        do {
            String menu = "---GESTIÓN DE HABITACIONES---\n"
                        + "1. Registrar nueva habitación\n"
                        + "2. Consultar disponibilidad\n"
                        + "3. Modificar datos de habitación\n"
                        + "---GESTIÓN DE CLIENTE---S\n"
                        + "4. Registrar nuevo cliente\n"
                        + "---GESTIÓN DE RESERVAS---\n"
                        + "5. Realizar reserva\n"
                        + "6. Cancelar reserva\n"
                        + "7. Salir del sistema";

            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcion) {
                case 1: registrarHabitacion(); break;
                case 2: consultarDisponibilidad(); break;
                case 3: modificarHabitacion(); break;
                case 4: registrarCliente(); break;
                case 5: realizarReserva(); break;
                case 6: cancelarReserva(); break;
                case 7: JOptionPane.showMessageDialog(null, "Gracias por usar el sistema"); break;
                default: JOptionPane.showMessageDialog(null, "Opción no válida");
            }
        } while (opcion != 7);
    }

    static void registrarHabitacion() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID de habitación:"));
        String tipo = JOptionPane.showInputDialog("Tipo (Sencilla/Doble/Suite):");

        if (hab1 == null) hab1 = new Habitacion(id, tipo);
        else if (hab2 == null) hab2 = new Habitacion(id, tipo);
        else if (hab3 == null) hab3 = new Habitacion(id, tipo);
        else {
            JOptionPane.showMessageDialog(null, "Máximo número de habitaciones alcanzado.");
            return;
        }
        JOptionPane.showMessageDialog(null, "Habitación registrada.");
    }

    static void consultarDisponibilidad() {
        String msg = "";
        if (hab1 != null && hab1.disponible) msg += hab1 + "\n";
        if (hab2 != null && hab2.disponible) msg += hab2 + "\n";
        if (hab3 != null && hab3.disponible) msg += hab3 + "\n";

        JOptionPane.showMessageDialog(null, msg.equals("") ? "No hay habitaciones disponibles." : msg);
    }

    static void modificarHabitacion() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID de habitación a modificar:"));
        Habitacion h = buscarHabitacion(id);
        if (h != null) {
            String nuevoTipo = JOptionPane.showInputDialog("Nuevo tipo de habitacion (Sencilla/Doble/Suite)(:");
            h.tipo = nuevoTipo;
            JOptionPane.showMessageDialog(null, "Habitación modificada.");
        } else {
            JOptionPane.showMessageDialog(null, "Habitación no encontrada.");
        }
    }

    static void registrarCliente() {
        String nombre = JOptionPane.showInputDialog("Nombre del cliente:");
        String cedula = JOptionPane.showInputDialog("Cédula del cliente:");

        if (cli1 == null) cli1 = new Cliente(nombre, cedula);
        else if (cli2 == null) cli2 = new Cliente(nombre, cedula);
        else if (cli3 == null) cli3 = new Cliente(nombre, cedula);
        else {
            JOptionPane.showMessageDialog(null, "Máximo número de clientes alcanzado.");
            return;
        }
        JOptionPane.showMessageDialog(null, "Cliente registrado.");
    }

    static void realizarReserva() {
        String cedula = JOptionPane.showInputDialog("Cédula del cliente:");
        Cliente c = buscarCliente(cedula);
        if (c == null) {
            JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
            return;
        }

        String disponibles = "";
        if (hab1 != null && hab1.disponible) disponibles += hab1 + "\n";
        if (hab2 != null && hab2.disponible) disponibles += hab2 + "\n";
        if (hab3 != null && hab3.disponible) disponibles += hab3 + "\n";

        if (disponibles.equals("")) {
            JOptionPane.showMessageDialog(null, "No hay habitaciones disponibles.");
            return;
        }

        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID de habitación a reservar:\n" + disponibles));
        Habitacion h = buscarHabitacion(id);
        if (h != null && h.disponible) {
            if (res1 == null) res1 = new Reserva(h, c);
            else if (res2 == null) res2 = new Reserva(h, c);
            else if (res3 == null) res3 = new Reserva(h, c);
            else {
                JOptionPane.showMessageDialog(null, "Máximo número de reservas alcanzado.");
                return;
            }
            JOptionPane.showMessageDialog(null, "Reserva realizada.");
        } else {
            JOptionPane.showMessageDialog(null, "Habitación no disponible.");
        }
    }

    static void cancelarReserva() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID de habitación a cancelar:"));

        if (res1 != null && res1.habitacion.id == id) {
            res1.habitacion.disponible = true; res1 = null;
            JOptionPane.showMessageDialog(null, "Reserva cancelada."); return;
        }
        if (res2 != null && res2.habitacion.id == id) {
            res2.habitacion.disponible = true; res2 = null;
            JOptionPane.showMessageDialog(null, "Reserva cancelada."); return;
        }
        if (res3 != null && res3.habitacion.id == id) {
            res3.habitacion.disponible = true; res3 = null;
            JOptionPane.showMessageDialog(null, "Reserva cancelada."); return;
        }

        JOptionPane.showMessageDialog(null, "Reserva no encontrada.");
    }

    static Habitacion buscarHabitacion(int id) {
        if (hab1 != null && hab1.id == id) return hab1;
        if (hab2 != null && hab2.id == id) return hab2;
        if (hab3 != null && hab3.id == id) return hab3;
        return null;
    }

    static Cliente buscarCliente(String cedula) {
        if (cli1 != null && cli1.cedula.equals(cedula)) return cli1;
        if (cli2 != null && cli2.cedula.equals(cedula)) return cli2;
        if (cli3 != null && cli3.cedula.equals(cedula)) return cli3;
        return null;
    }
}


        
        
        
    
