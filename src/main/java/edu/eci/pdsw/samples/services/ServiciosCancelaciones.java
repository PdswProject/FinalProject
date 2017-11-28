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
       a indicar, dada la asignatura a cancelar, 
       cuantos créditos académicos tendría pendiente por ver.
     * @param e Estudiante a calcular
     * @param asig The subject that you want cancel.
     * @return The number of credit that will be pending.
     * @throws edu.eci.pdsw.samples.services.ExcepcionSolicitudes algo
     * @return the int lo retorna
     */
    public abstract int calcularImpacto(Estudiante e, Asignatura asig) throws ExcepcionSolicitudes;
    
    
    /**
     * Extrae el plan de estudios del estudiante
     * @param e Estudiante a extraer
     * @return retorna un plan de estudios
     * @throws ExcepcionSolicitudes La expecion
     */
    public abstract PlanEstudios extraerPlanEstudios(Estudiante e)throws ExcepcionSolicitudes; 
    
    /**
     * El sistema debe permitir seleccionar sólo 
     * aquellas asignaturas que esté actualmente 
     * viendo el usuario.
     * @param e retorna una lista con las asignaturas actuales
     * @return List of Asignatura.
     * @throws edu.eci.pdsw.samples.services.ExcepcionSolicitudes La otra excepcion
     */
    public abstract List<Asignatura> verMateriasActuales(Estudiante e) throws ExcepcionSolicitudes;
    
    /**
     * Solicitar cancelacion
     * @param e   Estudiante a solicitar
     * @param a  Asignaruta a cancelar
     * @param justificacion Justificacion a dar
     * @param planEstudio  Justificacion para cancelar
     * @throws edu.eci.pdsw.samples.services.ExcepcionSolicitudes Exception para amergemcias
     */
    
    public abstract void solicitarCancelacion(Estudiante e, Asignatura a, String justificacion, PlanEstudios planEstudio) throws ExcepcionSolicitudes;
       
    /**
     * Permite ajustar el numero maximo de creditos que se pueda ver por semestre
     * @param numcreditos Descriprion Cantidad de creditos
     * @throws ExcepcionSolicitudes Expcepcion Exception para amergemcias
     */
    public abstract void ajustarMaxCreditosSemestre(int numcreditos) throws ExcepcionSolicitudes;
    
    
    
    /**
     * Permite agregar una materia al plan de estudios de determinado programa academico
     * @param programa PROGRAMA academico ingresado
     * @param plan Plan de estudios vigente
     * @param a Asignatura a agregar
     * @throws ExcepcionSolicitudes  Expcepcion
     */
    public abstract void agregarMateria(String programa, int plan, Asignatura a) throws ExcepcionSolicitudes;
    
    /**
     * Permite eliminar una materia al plan de estudios de determinado programa academico
     * @param programa programa inscrito
     * @param plan Plan de estudios vigente
     * @param a Asignarua a cancelar
     * @throws ExcepcionSolicitudes Excepcion
     */
    public abstract void eliminarMateria(String programa, int plan, Asignatura a) throws ExcepcionSolicitudes;
    
    /**
     * Valida que el grafo del plan de estudios sea dirigido, aciclico y que las asignaturas 
     * del mismo existan en el plan de estudios del estudiante
     * @param pe Plan de estudios
     * @return Booleano  return to boolean
     * @throws ExcepcionSolicitudes Si molesta
     */
    public abstract boolean validarPlanEstudios(PlanEstudios pe) throws ExcepcionSolicitudes;
    
    /**

     * Retorna una   lista de solicitudes de cancelacion.
     * @return  List retorna la lista e solicitudes
     * @throws ExcepcionSolicitudes Por si molesta
     */
    public abstract List<SolicitudCancelacion> getSolicitudCancelacion() throws ExcepcionSolicitudes;
}
