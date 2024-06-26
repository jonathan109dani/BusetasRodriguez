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
public class Vehiculo {
    private String placa;
    private String modelo;
    private String marca;
    private String capacidad; //String

    // Constructor vacío
    public Vehiculo() {
    }

    // Constructor con todos los atributos
    public Vehiculo(String placa, String modelo, String marca, String capacidad) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.capacidad = capacidad;
    }

    // Getters y Setters
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    // Método toString para representación textual del objeto
    @Override
    public String toString() {
        return "Vehiculo: " + "\n" +
                "Placa= " + placa + "\n" +
                "Modelo='" + modelo + "\n" +
                "Marca='" + marca + "\n" +
                "Capacidad=" + capacidad + "\n" + 
                "**********************************************\n";
    }
}