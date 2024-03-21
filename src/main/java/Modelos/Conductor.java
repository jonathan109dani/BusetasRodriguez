/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class Conductor {
    // Atributos
    private String nombre;
    private String apellido;
    private String cedula;
    private String telefono;
    private int numeroConductor;

    // Lista estática para almacenar todos los conductores creados
    private static ArrayList<Conductor> conductores = new ArrayList<>();

    // Constructor
    public Conductor(String nombre, String apellido, String cedula, String telefono, int numeroConductor) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.telefono = telefono;
        this.numeroConductor = numeroConductor;
        // Agregar el conductor recién creado a la lista de conductores
        conductores.add(this);
    }

    // Método para buscar un conductor por su ID
    public static Conductor buscarPorID(int id) {
        for (Conductor conductor : conductores) {
            if (conductor.numeroConductor == id) {
                return conductor;
            }
        }
        return null; // Retorna null si no se encuentra el conductor con el ID dado
    }

    // Método para eliminar un conductor
    public void eliminar() {
        if (conductores.contains(this)) {
            conductores.remove(this);
            System.out.println("Conductor eliminado: " + nombre + " " + apellido);
        } else {
            System.out.println("El conductor no está en la lista.");
        }
    }

    // Método para visualizar los detalles del conductor
    public void visualizar() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Cédula: " + cedula);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Número de conductor: " + numeroConductor);
    }

    // Método para editar los detalles del conductor
    public void editar(String nombre, String apellido, String cedula, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.telefono = telefono;
        System.out.println("Conductor editado correctamente.");
    }
}
