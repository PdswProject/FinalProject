/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.eci.pdsw.samples.entities;

import java.util.Date;

/**
 *
 * @author cesar
 */
public class SolicitudCancelacion {
    private int id;
    private String justificacion;
    private Asignatura materia;
    private int nombAsignatura;
    private Date fecha;
    private String estado;//TOCA CAMBIARLO DE BOOLEAN A VARCAHR PORQUE ASI ESTA EN LA BASE DE DATOS
    private Integer estu;
    
    public SolicitudCancelacion(){
    }
        public SolicitudCancelacion(String justificacion, Asignatura materia, Date fecha, String estado){
        this.justificacion=justificacion;
        this.materia=materia;
        this.fecha=fecha;
        this.estado=estado;
        
        }
    public SolicitudCancelacion(String justificacion, Asignatura materia, Date fecha, String estado, Integer estu){
        this.justificacion=justificacion;
        this.materia=materia;
        this.fecha=fecha;
        this.estado=estado;
        this.estu=estu;
     }
    
    public void setJustificacion(String justifiacion){
        this.justificacion=justifiacion;
    
    }
    public void setMateria(Asignatura materia){
        this.materia=materia;
    }
    public void setEstado(String estado){
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
    public String getEstado(){
        return estado;
    }
    public Integer getEstu(){
        return estu;
    }
    public void setEstu(Integer estu   ){
        this.estu=estu;
    }
    
    public void setNombAsig(int nombAsignatura){
        this.nombAsignatura=nombAsignatura;
    }
    public Integer getNombAsig(){
        return nombAsignatura;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    
    }
}
