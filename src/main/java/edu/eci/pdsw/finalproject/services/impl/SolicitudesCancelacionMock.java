/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.finalproject.services.impl;

import edu.eci.pdsw.finalproject.entities.Asignatura;
import edu.eci.pdsw.finalproject.entities.PlanEstudios;
import edu.eci.pdsw.finalproject.entities.ProgramaAcademico;
import edu.eci.pdsw.finalproject.services.ExcepcionSolicitudes;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author USER
 */
public final class SolicitudesCancelacionMock {
    
    private final List<Asignatura> asignaturasPlanEstudios;
    
    public SolicitudesCancelacionMock(){
        asignaturasPlanEstudios = new LinkedList<>();
        cargarDatosPrueba();
        
        
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
        return 0;
        
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
    
    public void registroJustificacion() throws ExcepcionSolicitudes{
        throw new ExcepcionSolicitudes("No implementado aun");
        
       
    }

    public List<Asignatura> getAsignaturasPlanEstudios() {
        return asignaturasPlanEstudios;
    }
    
    
    public void cargarDatosPrueba(){
        
        ProgramaAcademico p1= new ProgramaAcademico(1, "Ingenieria Sistemas", 10, 210, 150);
      
        Asignatura as1 = new Asignatura(101, "Logica", p1, "Departamento Matematica", 504, 111);
        Asignatura as2 = new Asignatura(102, "Modelos", p1, "Departamento Matematica", 505, 111);
        Asignatura as3 = new Asignatura(103, "Redes", p1, "Departamento Matematica", 510, 111);
        
        asignaturasPlanEstudios.add(as1);
        asignaturasPlanEstudios.add(as2);
        asignaturasPlanEstudios.add(as3);
        
        PlanEstudios plan= new PlanEstudios(1, 3, p1, asignaturasPlanEstudios);
    }
    
    
}
