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
public class Estudiante {
    private int id;
    private String nombre;
    private String apellido;
    /**
     * El numero del plan de estudios que esta viendo.
     */
    private int planEstudios;
    
    /**
     * El programa academico en el que se encuentra.
     */
    private ProgramaAcademico programaAcademico;
    
    
    private int semestre;
    private int creditosAprobados;
    private int solicitud_cancelacion;
    private int acudiente;
    private int consejero_academico;
    //private Asignatura[] materiasActuales;
    private List<Asignatura> materiasActuales;
    
    public Estudiante(){}
    
    public Estudiante(int id, String nombre, String apellido,int planEstudios,ProgramaAcademico programaAcademico, int semestre, int creditos_aprobados, int solicitud_cancelacion, int acudiente, int consejero_academico, List<Asignatura> materiasActuales) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.planEstudios=planEstudios;
        this.programaAcademico=programaAcademico;
        this.semestre = semestre;
        this.creditosAprobados = creditos_aprobados;
        this.solicitud_cancelacion = solicitud_cancelacion;
        this.acudiente = acudiente;
        this.consejero_academico = consejero_academico;
        //this.materiasActuales = materiasActuales;
        materiasActuales=new ArrayList<Asignatura>();
    }
       
            
    public int getPlanEstudios() {     

        return planEstudios;
    }

    public void setPlanEstudios(int planEstudios) {
        this.planEstudios = planEstudios;
    }

    public ProgramaAcademico getProgramaAcademico() {
        return programaAcademico;
    }
    public void setProgramaAcademico(ProgramaAcademico programaAcademico) {
        this.programaAcademico = programaAcademico;
    }
    
    //public Asignatura[] getMateriaActual() {
    public List<Asignatura>getMateriaActual() {
        return materiasActuales;
    }

    //public void setMateriaActual(Asignatura[] materiasActuales) {    
    public void setMateriaActual(List<Asignatura> materiasActuales) {
        
        this.materiasActuales = materiasActuales;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getCreditos_aprobados() {
        return creditosAprobados;
    }

    public void setCreditos_aprobados(int creditos_aprobados) {
        this.creditosAprobados = creditos_aprobados;
    }

    public int getSolicitud_cancelacion() {
        return solicitud_cancelacion;
    }

    public void setSolicitud_cancelacion(int solicitud_cancelacion) {
        this.solicitud_cancelacion = solicitud_cancelacion;
    }

    public int getAcudiente() {
        return acudiente;
    }

    public void setAcudiente(int acudiente) {
        this.acudiente = acudiente;
    }

    public int getConsejero_academico() {
        return consejero_academico;
    }

    public void setConsejero_academico(int consejero_academico) {
        this.consejero_academico = consejero_academico;
    }
    
    
}
