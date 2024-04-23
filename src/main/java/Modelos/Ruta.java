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
    private String placa;
    private int ID_Escuela;

    public Ruta() {
    }

    public Ruta(String placa, int ID_Escuela) {
        this.placa = placa;
        this.ID_Escuela = ID_Escuela;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getID_Escuela() {
        return ID_Escuela;
    }

    public void setID_Escuela(int ID_Escuela) {
        this.ID_Escuela = ID_Escuela;
    }

    @Override
    public String toString() {
        return "Ruta{" +
                "placa='" + placa + '\'' +
                ", ID_Escuela=" + ID_Escuela +
                '}';
    }
}
