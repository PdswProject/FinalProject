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
public class Asignatura {
    private int codigo;
    private String nombre;
    private ProgramaAcademico programa;
    private String unidadAcademica;
    private boolean aprobada;
    private int vecesCancelada;
    private int creditos;
    private int profesor;
    private List<Asignatura> correquisitos;

    
    
    public Asignatura(int codigo,List<Asignatura> correquisitos){
    
        this.codigo=codigo;
        this.correquisitos=correquisitos;
    }
    public Asignatura(int codigo, String nombre, ProgramaAcademico programa, String unidadAcademica, int profesor, int creditos) {
        this.codigo=codigo;
        this.nombre = nombre;
        this.programa = programa;
        this.unidadAcademica = unidadAcademica;
        this.profesor = profesor;
        this.creditos=creditos;
    }

    public Asignatura(int codigo, String nombre, ProgramaAcademico programa, String unidadAcademica, int profesor, int creditos, List<Asignatura> correquisitos)
    {
        this(codigo, nombre, programa, unidadAcademica, profesor, creditos);
        this.correquisitos=correquisitos;
        
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

    public List<Asignatura> getCorrequisitos() {
        return correquisitos;
    }

    public void setCorrequisitos(List<Asignatura> correquisitos) {
        this.correquisitos = correquisitos;
    }
    
}
