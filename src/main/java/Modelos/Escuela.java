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
    private String ID_Escuela;
    private String nombre;
    private String ubicacion;

    // Constructor sin parámetros
    public Escuela() {
    }

    // Constructor con parámetros
    public Escuela(String ID_Escuela, String nombre, String ubicacion) {
        this.ID_Escuela = ID_Escuela;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    // Getter y setter para ID_Escuela
    public String getID_Escuela() {
        return ID_Escuela;
    }

    public void setID_Escuela(String ID_Escuela) {
        this.ID_Escuela = ID_Escuela;
    }

    // Getter y setter para nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter y setter para ubicacion
    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    // Método toString para representar la información de la escuela
    @Override
    public String toString() {
        return "Escuela{" +
                "ID_Escuela=" + ID_Escuela +
                ", nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                '}';
    }
}