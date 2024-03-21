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
    // Atributos
    public static void setClientes(ArrayList<Cliente> clientes) {
        Cliente.clientes = clientes;
    }
    private String nombre;
    private String apellido;
    private String cedula;
    private String telefono;
    
    // Lista estática para almacenar todos los clientes creados
    private static ArrayList<Cliente> clientes = new ArrayList<>();

    // Constructor
    public Cliente(String nombre, String apellido, String cedula, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.telefono = telefono;
        // Agregar el cliente recién creado a la lista de clientes
        clientes.add(this);
    }

    // Método para crear un cliente
    public static Cliente crear(String nombre, String apellido, String cedula, String telefono) {
        return new Cliente(nombre, apellido, cedula, telefono);
    }

    // Método para buscar un cliente por su cédula
    public static Cliente buscarPorCedula(String cedula) {
        for (Cliente cliente : clientes) {
            if (cliente.cedula.equals(cedula)) {
                return cliente;
            }
        }
        return null; // Retorna null si no se encuentra el cliente con la cédula dada
    }

    // Método para editar un cliente
    public void editar(String nombre, String apellido, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        System.out.println("Cliente editado correctamente.");
    }

    // Método para eliminar un cliente
    public void eliminar() {
        if (clientes.contains(this)) {
            clientes.remove(this);
            System.out.println("Cliente eliminado: " + nombre + " " + apellido);
        } else {
            System.out.println("El cliente no está en la lista.");
        }
    }

    // Método para visualizar los detalles del cliente
    public void visualizar() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Cédula: " + cedula);
        System.out.println("Teléfono: " + telefono);
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }

}
