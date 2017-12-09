/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.services;

import edu.eci.pdsw.samples.entities.Asignatura;
import edu.eci.pdsw.samples.entities.Estudiante;
import edu.eci.pdsw.samples.entities.PlanEstudios;

/**
 *
 * @author DANIEL CIFUENTES
 */
public interface CalculadorDeImpacto {
    
    /**
     * Calcula el impacto de cancelar una o mas asignaturas.
     * @param asigs un arreglo con las asignaturas a cancelar.
     * @param plan El plan de estudios del estudiante.
     * @return el numero de creditos que se dejarian de ver si se decide cancelar
     */
    public int calcularImpacto(Asignatura[] asigs, PlanEstudios plan);
    
    /**
     * Verifica que el grafo que representa un plan de estudios sea aciclico y dirigido.
     * @param plan El plan de estudios a verificar
     * @return true si se acepta el plan de estudios, false de lo contrario
     */
    public boolean verificarPlanEstudios(PlanEstudios plan);
    
}