/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.services.impl;

import edu.eci.pdsw.samples.entities.Asignatura;
import edu.eci.pdsw.samples.entities.PlanEstudios;
import edu.eci.pdsw.samples.services.CalculadorDeImpacto;
import java.util.List;

/**
 *
 * @author DANIEL CIFUENTES
 */
public class CalculadorDeImpactoSimple implements CalculadorDeImpacto{

    @Override
    public int calcularImpacto(Asignatura[] asigna, PlanEstudios plan) {
        
        verificarPlanEstudios(plan);
        int resp=0;
        for(Asignatura asi:asigna)
            resp+=calcularImpacto(asi);
        
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
        
        return false;
    }
    
}
