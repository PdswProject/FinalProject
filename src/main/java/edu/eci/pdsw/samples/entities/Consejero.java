/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class Consejero {
    
    private List<Estudiante> listaEstudiantes;
    private String Nombre;
    private Asignatura materiaAsignada;//Esta no se bien
    private String Comentarios;
    private int id;
    private boolean aval;
    
    public Consejero(boolean aval,String Nombre, String Comentarios){
        this.aval=aval;
        listaEstudiantes=new ArrayList<Estudiante>();
        this.Nombre=Nombre;
        this.Comentarios=Comentarios;
        

    }
    
    
    
    
}
