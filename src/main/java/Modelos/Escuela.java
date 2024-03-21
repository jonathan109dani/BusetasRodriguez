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
public class Escuela {
    // Atributos
    public static void setEscuelas(ArrayList<Escuela> escuelas) {
        Escuela.escuelas = escuelas;
    }
    private String nombre;
    private String provincia;
    private String distrito;

    // Lista estática para almacenar todas las escuelas creadas
    private static ArrayList<Escuela> escuelas = new ArrayList<>();

    // Constructor
    public Escuela(String nombre, String provincia, String distrito) {
        this.nombre = nombre;
        this.provincia = provincia;
        this.distrito = distrito;
        // Agregar la escuela recién creada a la lista de escuelas
        escuelas.add(this);
    }

    // Métodos CRUD

    // Método para crear una escuela
    public static Escuela crear(String nombre, String provincia, String distrito) {
        return new Escuela(nombre, provincia, distrito);
    }

    // Método para buscar una escuela por su nombre
    public static Escuela buscarPorNombre(String nombre) {
        for (Escuela escuela : escuelas) {
            if (escuela.nombre.equals(nombre)) {
                return escuela;
            }
        }
        return null; // Retorna null si no se encuentra la escuela con el nombre dado
    }

    // Método para editar una escuela
    public void editar(String nombre, String provincia, String distrito) {
        this.nombre = nombre;
        this.provincia = provincia;
        this.distrito = distrito;
        System.out.println("Escuela editada correctamente.");
    }

    // Método para eliminar una escuela
    public void eliminar() {
        if (escuelas.contains(this)) {
            escuelas.remove(this);
            System.out.println("Escuela eliminada: " + nombre);
        } else {
            System.out.println("La escuela no está en la lista.");
        }
    }

    // Método para visualizar los detalles de la escuela
    public void visualizar() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Ubicación: " + provincia + ", " + distrito);
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public static ArrayList<Escuela> getEscuelas() {
        return escuelas;
    }
    
    
    // Método toString para imprimir los detalles de la ubicación
    @Override
        public String toString() {
            return "Ubicacion{" +
                    "provincia='" + provincia + '\'' +
                    ", distrito='" + distrito + '\'' +
                    '}';
    }
}