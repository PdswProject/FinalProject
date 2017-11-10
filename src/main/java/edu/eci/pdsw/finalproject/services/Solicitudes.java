/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.finalproject.services;

import edu.eci.pdsw.finalproject.entities.Asignatura;
import edu.eci.pdsw.finalproject.entities.Estudiante;
import edu.eci.pdsw.finalproject.entities.PlanEstudios;
import java.util.List;

/**
 *
 * @author 2104784
 */
public interface Solicitudes {
    
    /**
     * Algoritmo de cálculo de impacto que se limita
       a indicar, dada la asignatura a cancelar, 
       cuantos créditos académicos tendría pendiente por ver.
     * @param asig The subject that you want cancel.
     * @return The number of credit that will be pending.
     * @throws edu.eci.pdsw.finalproject.services.ExcepcionSolicitudes
     */
    public abstract int calculoImpactoSimple(Asignatura asig) throws ExcepcionSolicitudes;
    
    
    
    /**
     * El sistema debe permitir seleccionar sólo 
     * aquellas asignaturas que esté actualmente 
     * viendo el usuario.
     * @param e
     * @return List of Asignatura.
     * @throws edu.eci.pdsw.finalproject.services.ExcepcionSolicitudes
     */
    public abstract List<Asignatura> loadAsignaturasActuales(Estudiante e) throws ExcepcionSolicitudes;
    
    
    
    /**
     * El sistema debe solcitar y registrar un texto con la justificacion de la solicitud
     * @throws edu.eci.pdsw.finalproject.services.ExcepcionSolicitudes
     */
    
    public abstract void registroJustificacion()throws ExcepcionSolicitudes;
        

    /**
     * Seleccionar todas las asignaturas de un pkan de estudios.
     * @param plan
     * @return List of Asignatura.
     * @throws edu.eci.pdsw.finalproject.services.ExcepcionSolicitudes
     */
    public abstract List<Asignatura> loadAsignaturasPlanEstudios(PlanEstudios plan) throws ExcepcionSolicitudes;
}
