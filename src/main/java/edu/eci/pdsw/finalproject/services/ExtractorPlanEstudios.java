/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.finalproject.services;

import edu.eci.pdsw.finalproject.entities.PlanEstudios;

/**
 *
 * @author DANIEL CIFUENTES
 */
public interface ExtractorPlanEstudios {
    
    /**
     * crea un objeto plan de estudios, con todas sus materias, a partir de un archivo
     * @param planEstudios el numero del plan de estudios
     * @param programaAcademico el nombre del programa academico sin espacios (IngenieriaDeSistemas, por ejemplo)
     * @return un objeto(grafo) que representa el plan de estudios
     */
    public PlanEstudios extraerPlanEstudios(int planEstudios,String programaAcademico);
    
}
