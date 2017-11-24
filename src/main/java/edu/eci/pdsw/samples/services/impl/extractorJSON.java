/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.services.impl;

import edu.eci.pdsw.samples.entities.PlanEstudios;
import edu.eci.pdsw.samples.services.ExtractorPlanEstudios;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author DANIEL CIFUENTES
 */
public class extractorJSON implements ExtractorPlanEstudios{

    @Override
    public PlanEstudios extraerPlanEstudios(int planEstudios, String programaAcademico) {
        JSONParser parser = new JSONParser();
        String a1="\"Asignatura\":{\"id\":1,\"correquisitos\":[]}";
        String a4="\"Asignatura\":{\"id\":4,\"correquisitos\":[]}";
        String a5="\"Asignatura\":{\"id\":5,\"correquisitos\":[]}";
        String a3="\"Asignatura\":{\"id\":3,\"correquisitos\":["+a5+"]}";
        String a2="\"Asignatura\":{\"id\":2,\"correquisitos\":["+a3+','+a4+"]}";
        
        
        String plan="{"
                + "\"PlanEstudios\":{\"id\":1,"
                              + "\"asignaturas\":"
                                + "["+a1+','+a2+','+a3+','+a4+','+a5+"]}"
                + "}";
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
