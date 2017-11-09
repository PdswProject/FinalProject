/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.finalproject.entities;

import java.util.List;

/**
 *
 * @author USER
 */
public class ProgramaAcademico {
    int id;
    String nombre;
    int plan_estudios;
    int decano;
    int numero_creditos;

    public ProgramaAcademico(int id, String nombre, int plan_estudios, int decano, int numero_creditos) {
        this.id = id;
        this.nombre = nombre;
        this.plan_estudios = plan_estudios;
        this.decano = decano;
        this.numero_creditos = numero_creditos;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPlan_estudios() {
        return plan_estudios;
    }

    public void setPlan_estudios(int plan_estudios) {
        this.plan_estudios = plan_estudios;
    }

    public int getDecano() {
        return decano;
    }

    public void setDecano(int decano) {
        this.decano = decano;
    }

    public int getNumero_creditos() {
        return numero_creditos;
    }

    public void setNumero_creditos(int numero_creditos) {
        this.numero_creditos = numero_creditos;
    }
    
    
    
}
