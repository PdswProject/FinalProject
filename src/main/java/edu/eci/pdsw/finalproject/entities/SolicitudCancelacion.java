/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.eci.pdsw.finalproject.entities;

import java.util.Date;

/**
 *
 * @author cesar
 */
public class SolicitudCancelacion {
    private int id;
    private String justificacion;
    private Asignatura materia;
    private Date fecha;
    private boolean estado;
    
    
    public SolicitudCancelacion(){
    }
    public SolicitudCancelacion(String justificacion, Asignatura materia, Date fecha, boolean estado){
        this.justificacion=justificacion;
        this.materia=materia;
        this.fecha=fecha;
        this.estado=estado;
     }
    
    public void setJustificacion(String justifiacion){
        this.justificacion=justifiacion;
    
    }
    public void setMateria(Asignatura materia){
        this.materia=materia;
    }
    public void setEstado(boolean estado){
        this.estado=estado;
    }
        
    public String getJustificacion(){
        return justificacion;
    }
    public Asignatura getAsignatura(){
        return materia;
    }
    public Date getFecha(){
        return fecha;
    }
    public boolean getEstado(){
        return estado;
    }
    
}
