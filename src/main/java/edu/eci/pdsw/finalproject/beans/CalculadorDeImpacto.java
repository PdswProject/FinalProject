/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.finalproject.beans;

import edu.eci.pdsw.finalproject.entities.Asignatura;
import edu.eci.pdsw.finalproject.entities.PlanEstudios;

/**
 *
 * @author 2104481
 */
public interface CalculadorDeImpacto {
    
    public int calcularImpacto(PlanEstudios p, Asignatura a);
    
}
