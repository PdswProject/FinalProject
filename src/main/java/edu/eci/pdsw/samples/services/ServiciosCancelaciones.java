/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.services;

import edu.eci.pdsw.samples.entities.Asignatura;
import edu.eci.pdsw.samples.entities.Estudiante;
import edu.eci.pdsw.samples.entities.PlanEstudios;
import edu.eci.pdsw.samples.entities.SolicitudCancelacion;
import java.util.List;

/**
 *
 * @author 2104784
 */
public interface ServiciosCancelaciones {
        
    /**
     * Algoritmo de cálculo de impacto que se limita
       a indicar, dado un arreglo de asignaturas a cancelar, 
       cuantos créditos académicos tendría pendiente por ver.
     * @param e
     * @param asigs Un arreglo con las materias que se quieren cancelar.
     * @return The number of credit that will be pending.
     * @throws edu.eci.pdsw.samples.services.ExcepcionSolicitudes
     */
    public abstract int calcularImpacto(Estudiante e, Asignatura[] asigs) throws ExcepcionSolicitudes;
    
    
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
    //public abstract Asignatura[] verMateriasActuales(Estudiante e) throws ExcepcionSolicitudes;
    public abstract List<Asignatura> verMateriasActuales(Estudiante e) throws ExcepcionSolicitudes;
    
    
    
    
    /**
     * Solicitar cancelacion
     * @param e
     * @param a
     * @param justificacion
     * @throws edu.eci.pdsw.finalproject.services.ExcepcionSolicitudes
     */
    
    public abstract void solicitarCancelacion(Estudiante e, Asignatura a, String justificacion, PlanEstudios planEstudio) throws ExcepcionSolicitudes;
        

    
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
    
    /**
     * Retorna una   lista de solicitudes de cancelacion.
     * @return  List retorna la lista e solicitudes
     * @throws ExcepcionSolicitudes Por si molesta
     */
    public abstract List<SolicitudCancelacion> getSolicitudCancelacion() throws ExcepcionSolicitudes;
}