/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.services.impl;

import edu.eci.pdsw.samples.entities.Asignatura;
import edu.eci.pdsw.samples.entities.PlanEstudios;
import edu.eci.pdsw.samples.services.ExtractorPlanEstudios;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author DANIEL CIFUENTES
 */
public class ExtractorJSON implements ExtractorPlanEstudios{

    @Override
    public PlanEstudios extraerPlanEstudios(int planEstudios, String programaAcademico) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("src/main/resources/PlanesDeEstudioPruebas/"+programaAcademico + planEstudios+".json"));
            JSONObject o = (JSONObject)obj;
            
            JSONArray asignaturas= (JSONArray)o.get("asignaturas");
            Asignatura[] asigs= new Asignatura[asignaturas.size()];
            
            for(int i=0;i<asigs.length;i++)
            {
                Long id=(Long)((JSONObject)asignaturas.get(i)).get("id");
                Long creditos=(Long)((JSONObject)asignaturas.get(i)).get("creditos");
                asigs[i]= new Asignatura(id.intValue(),creditos.intValue());
            }
            for(int i=0;i<asigs.length;i++)
            {
                JSONArray correquisitos=(JSONArray)((JSONObject)asignaturas.get(i)).get("correquisitos");
                Asignatura[] correqs=new Asignatura[correquisitos.size()];
                for(int j=0;j<correqs.length;j++)
                {
                    Long c = (Long)correquisitos.get(j);
                    correqs[j]=asigs[c.intValue()-1];
                }
                asigs[i].setCorrequisitos(Arrays.asList(correqs));
            }
            
            
            Long idPlan= (Long)o.get("id");
            return new PlanEstudios(idPlan.intValue(), asigs.length, null, Arrays.asList(asigs));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExtractorJSON.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ExtractorJSON.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ExtractorJSON.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
