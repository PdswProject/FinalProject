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
     * @param e
     * @param asig The subject that you want cancel.
     * @return The number of credit that will be pending.
     * @throws edu.eci.pdsw.finalproject.services.ExcepcionSolicitudes
     * @return the int
     */
    public abstract int calcularImpacto(Estudiante e, Asignatura asig) throws ExcepcionSolicitudes;
    
    
    /**
     * Extrae el plan de estudios del estudiante
     * @param e
     * @return
     * @throws ExcepcionSolicitudes 
     */
    public abstract PlanEstudios extraerPlanEstudios(Estudiante e)throws ExcepcionSolicitudes; 
    
    /**
     * El sistema debe permitir seleccionar sólo 
     * aquellas asignaturas que esté actualmente 
     * viendo el usuario.
     * @param e
     * @return List of Asignatura.
     * @throws edu.eci.pdsw.finalproject.services.ExcepcionSolicitudes
     */
    public abstract List<Asignatura> verMateriasActuales(Estudiante e) throws ExcepcionSolicitudes;
    
    
    
    
    /**
     * Solicitar cancelacion
     * @param e
     * @param a
     * @param justificacion
     * @throws edu.eci.pdsw.finalproject.services.ExcepcionSolicitudes
     */
    
    public abstract void solicitarCancelacion(Estudiante e, Asignatura a, String justificacion) throws ExcepcionSolicitudes;
        

    
    /**
     * Permite ajustar el numero maximo de creditos que se pueda ver por semestre
     * @param numcreditos
     * @throws ExcepcionSolicitudes 
     */
    public abstract void ajustarMaxCreditosSemestre(int numcreditos) throws ExcepcionSolicitudes;
    
    
    
    /**
     * Permite agregar una materia al plan de estudios de determinado programa academico
     * @param programa
     * @param plan
     * @param a
     * @throws ExcepcionSolicitudes 
     */
    public abstract void agregarMateria(String programa, int plan, Asignatura a) throws ExcepcionSolicitudes;
    
    
    
    /**
     * Permite eliminar una materia al plan de estudios de determinado programa academico
     * @param programa
     * @param plan
     * @param a
     * @throws ExcepcionSolicitudes 
     */
    public abstract void eliminarMateria(String programa, int plan, Asignatura a) throws ExcepcionSolicitudes;
    
        
        
        
    
    /**
     * Valida que el grafo del plan de estudios sea dirigido, aciclico y que las asignaturas 
     * del mismo existan en el plan de estudios del estudiante
     * @param pe
     * @return
     * @throws ExcepcionSolicitudes 
     */
    public abstract boolean validarPlanEstudios(PlanEstudios pe) throws ExcepcionSolicitudes;
}
