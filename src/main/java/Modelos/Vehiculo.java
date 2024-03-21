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
    // Atributos
    private String placa;
    private String marca;
    private String modelo;
    private int capacidadPasajeros;
    private String color;
    
    // Lista estática para almacenar todos los vehículos creados
    private static ArrayList<Vehiculo> vehiculos = new ArrayList<>();

    // Constructor
    public Vehiculo(String placa, String marca, String modelo, int capacidadPasajeros, String color) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.capacidadPasajeros = capacidadPasajeros;
        this.color = color;
        // Agregar el vehículo recién creado a la lista de vehículos
        vehiculos.add(this);
    }


    // Método para crear un vehículo
    public static Vehiculo crear(String placa, String marca, String modelo, int capacidadPasajeros, String color) {
        return new Vehiculo(placa, marca, modelo, capacidadPasajeros, color);
    }

    // Método para buscar un vehículo por su placa
    public static Vehiculo buscarPorPlaca(String placa) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.placa.equals(placa)) {
                return vehiculo;
            }
        }
        return null; // Retorna null si no se encuentra el vehículo con la placa dada
    }

    // Método para editar un vehículo
    public void editar(String marca, String modelo, int capacidadPasajeros, String color) {
        this.marca = marca;
        this.modelo = modelo;
        this.capacidadPasajeros = capacidadPasajeros;
        this.color = color;
        System.out.println("Vehículo editado correctamente.");
    }

    // Método para eliminar un vehículo
    public void eliminar() {
        if (vehiculos.contains(this)) {
            vehiculos.remove(this);
            System.out.println("Vehículo eliminado: " + placa);
        } else {
            System.out.println("El vehículo no está en la lista.");
        }
    }

    // Método para visualizar los detalles del vehículo
    public void visualizar() {
        System.out.println("Placa: " + placa);
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Capacidad de pasajeros: " + capacidadPasajeros);
        System.out.println("Color: " + color);
    }
    
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public void setCapacidadPasajeros(int capacidadPasajeros) {
        this.capacidadPasajeros = capacidadPasajeros;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public static void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        Vehiculo.vehiculos = vehiculos;
    }
}
