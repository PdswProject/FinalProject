/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.eci.pdsw.samples.entities;

/**
 *
 * @author cesar
 */
public class Acudiente {
    private String nombre;
    private int id;
    private boolean vistoBueno;
    private int estudiante_id;
    private String correo;

    public Acudiente(){}
    public Acudiente(String nombre, int id, int estudiante_id,String correo){
        this.nombre=nombre;
        this.id=id;
        this.estudiante_id=estudiante_id;
        this.vistoBueno=false;
        this.correo=correo;
    }
    public String getNOmbre(){
        return nombre;
    }
    public int getId(){
        return id;
    }
    public boolean getVitoBueno(){
        return vistoBueno;
    }
    public int getEstudianteId(){
        return estudiante_id;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setId(int id){
        this.id=id;
    
    }
    public void setEstudiante(int estudiante_id){
        this.estudiante_id=estudiante_id;
    }
    
    public void setVistoBueno(boolean vistoBueno){
        this.vistoBueno=vistoBueno;
    }
    public void setCorreo(String co){
        correo=co;
    }
    
    public String getCorreo(){
        return  correo;
    
    }
    
}
