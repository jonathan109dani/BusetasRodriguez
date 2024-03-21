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
public class Ruta {
    // Atributos
    public static void setRutas(ArrayList<Ruta> rutas) {
        Ruta.rutas = rutas;
    }
    private String puntoPartida;
    private ArrayList<String> puntosIntermedios;
    private String destinoFinal;
    
    // Lista estática para almacenar todas las rutas creadas
    private static ArrayList<Ruta> rutas = new ArrayList<>();

    // Constructor
    public Ruta(String puntoPartida, ArrayList<String> puntosIntermedios, String destinoFinal) {
        this.puntoPartida = puntoPartida;
        this.puntosIntermedios = puntosIntermedios;
        this.destinoFinal = destinoFinal;
        // Agregar la ruta recién creada a la lista de rutas
        rutas.add(this);
    }

    // Métodos CRUD

    // Método para crear una ruta
    public static Ruta crear(String puntoPartida, ArrayList<String> puntosIntermedios, String destinoFinal) {
        return new Ruta(puntoPartida, puntosIntermedios, destinoFinal);
    }

    // Método para buscar una ruta por su punto de partida
    public static Ruta buscarPorPuntoPartida(String puntoPartida) {
        for (Ruta ruta : rutas) {
            if (ruta.puntoPartida.equals(puntoPartida)) {
                return ruta;
            }
        }
        return null; // Retorna null si no se encuentra la ruta con el punto de partida dado
    }

    // Método para editar una ruta
    public void editar(String puntoPartida, ArrayList<String> puntosIntermedios, String destinoFinal) {
        this.puntoPartida = puntoPartida;
        this.puntosIntermedios = puntosIntermedios;
        this.destinoFinal = destinoFinal;
        System.out.println("Ruta editada correctamente.");
    }

    // Método para eliminar una ruta
    public void eliminar() {
        if (rutas.contains(this)) {
            rutas.remove(this);
            System.out.println("Ruta eliminada: " + puntoPartida + " - " + destinoFinal);
        } else {
            System.out.println("La ruta no está en la lista.");
        }
    }

    // Método para visualizar los detalles de la ruta
    public void visualizar() {
        System.out.println("Punto de partida: " + puntoPartida);
        System.out.println("Puntos intermedios:");
        for (String puntoIntermedio : puntosIntermedios) {
            System.out.println("- " + puntoIntermedio);
        }
        System.out.println("Destino final: " + destinoFinal);
    }
    
    
    public String getPuntoPartida() {
        return puntoPartida;
    }

    public void setPuntoPartida(String puntoPartida) {
        this.puntoPartida = puntoPartida;
    }

    public ArrayList<String> getPuntosIntermedios() {
        return puntosIntermedios;
    }

    public void setPuntosIntermedios(ArrayList<String> puntosIntermedios) {
        this.puntosIntermedios = puntosIntermedios;
    }

    public String getDestinoFinal() {
        return destinoFinal;
    }

    public void setDestinoFinal(String destinoFinal) {
        this.destinoFinal = destinoFinal;
    }

    public static ArrayList<Ruta> getRutas() {
        return rutas;
    }

}
