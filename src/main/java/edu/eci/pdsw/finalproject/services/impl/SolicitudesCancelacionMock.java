/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.finalproject.services.impl;

import edu.eci.pdsw.finalproject.entities.Asignatura;
import edu.eci.pdsw.finalproject.services.ExcepcionSolicitudes;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class SolicitudesCancelacionMock {
    
    public SolicitudesCancelacionMock(){
        
    }
    
    /**
     * Algoritmo de cálculo de impacto que se limita
       a indicar, dada la asignatura a cancelar, 
       cuantos créditos académicos tendría pendiente por ver.
     * @param asig The subject that you want cancel.
     * @return The number of credit that will be pending.
     * @throws edu.eci.pdsw.finalproject.services.ExcepcionSolicitudes
     */
    public int calculoImpactoSimple(Asignatura asig) throws ExcepcionSolicitudes{

        int resp=asig.getCreditos();
        return resp ;
            
    }
    
    /**
     * El sistema debe permitir seleccionar sólo 
     * aquellas asignaturas que esté actualmente 
     * viendo el usuario.
     * @return List of Asignatura.
     * @throws edu.eci.pdsw.finalproject.services.ExcepcionSolicitudes
     */
    public List<Asignatura> loadAsignaturasActuales() throws ExcepcionSolicitudes{
        throw new ExcepcionSolicitudes("No implementado aun");
    }
    
    
    
    /**
     * El sistema debe solcitar y registrar un texto con la justificacion de la solicitud
     * @throws edu.eci.pdsw.finalproject.services.ExcepcionSolicitudes
     */
    
    public String registroJustificacion() throws ExcepcionSolicitudes{

        throw new ExcepcionSolicitudes("No implementado aun");
        
        
    }
    
    
}
