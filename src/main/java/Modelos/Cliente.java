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
public class Cliente {
    private String cedula;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String ubicacion;
    

    public Cliente() {
    }

    public Cliente(String cedula, String nombre, String apellido1, String apellido2, String ubicacion) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.ubicacion = ubicacion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }


    @Override
    public String toString() {
        return "Cliente: " + "\n" +
                "Cedula= " + cedula + "\n" +
                "Nombre= " + nombre + "\n" +
                "Apellido1= " + apellido1 + "\n" +
                "Apellido2= " + apellido2 + "\n" +
                "Ubicacion= " + ubicacion + "\n" +
                "\n*****************************************************\n";
    }
}