/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.finalproject.entities;

/**
 *
 * @author USER
 */
public class Asignatura {
    int codigo;
    String nombre;
    ProgramaAcademico programa;
    String unidadAcademica;
    int profesor;
    int plan_estudios;
    int creditos;

    public Asignatura(int codigo, String nombre, ProgramaAcademico programa, String unidadAcademica, int profesor, int plan_estudios, int creditos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.programa = programa;
        this.unidadAcademica = unidadAcademica;
        this.profesor = profesor;
        this.plan_estudios = plan_estudios;
       this.creditos=creditos;
    }
    public int getCodigo() {
        return codigo;
    }
    public int getCreditos(){
        return creditos;
    }
    public void setCreditos(int creditos){
        this.creditos=creditos;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ProgramaAcademico getPrograma() {
        return programa;
    }

    public void setPrograma(ProgramaAcademico programa) {
        this.programa = programa;
    }

    public String getUnidadAcademica() {
        return unidadAcademica;
    }

    public void setUnidadAcademica(String unidadAcademica) {
        this.unidadAcademica = unidadAcademica;
    }

    public int getProfesor() {
        return profesor;
    }

    public void setProfesor(int profesor) {
        this.profesor = profesor;
    }

    public int getPlan_estudios() {
        return plan_estudios;
    }

    public void setPlan_estudios(int plan_estudios) {
        this.plan_estudios = plan_estudios;
    }
    
    
}
