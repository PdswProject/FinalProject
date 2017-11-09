/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.finalproject.entities;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author USER
 */
public class PlanEstudios {
    int id;
    int numero_materias;
    ProgramaAcademico programa;
    List<Asignatura> materias;

    public PlanEstudios(int id, int numero_materias, ProgramaAcademico programa, List<Asignatura> materias) {
        this.materias = new LinkedList();
        this.id = id;
        this.numero_materias = numero_materias;
        this.programa = programa;
        this.materias = materias;
    }

   

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero_materias() {
        return numero_materias;
    }

    public void setNumero_materias(int numero_materias) {
        this.numero_materias = numero_materias;
    }

    public ProgramaAcademico getPrograma() {
        return programa;
    }

    public void setPrograma(ProgramaAcademico programa) {
        this.programa = programa;
    }

    public List<Asignatura> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Asignatura> materias) {
        this.materias = materias;
    }


    
    
}
