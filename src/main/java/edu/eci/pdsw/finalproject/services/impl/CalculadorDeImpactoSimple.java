/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.finalproject.services.impl;

import edu.eci.pdsw.finalproject.entities.Asignatura;
import edu.eci.pdsw.finalproject.entities.PlanEstudios;
import edu.eci.pdsw.finalproject.services.CalculadorDeImpacto;

/**
 *
 * @author DANIEL CIFUENTES
 */
public class CalculadorDeImpactoSimple implements CalculadorDeImpacto{

    @Override
    public int calcularImpacto(Asignatura[] asigs, PlanEstudios plan) {
        
        //verificarPlanEstudios(plan);
        int resp=0;
        for(Asignatura asig:asigs)
            resp+=calcularImpacto(asig);
        return resp;
    }
    
    private int calcularImpacto(Asignatura asig)
    {
        int resp=asig.getCreditos();
        for (Asignatura a:asig.getCorrequisitos())
            resp+=calcularImpacto(a);
        return resp;
    }

    @Override
    public boolean verificarPlanEstudios(PlanEstudios plan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
