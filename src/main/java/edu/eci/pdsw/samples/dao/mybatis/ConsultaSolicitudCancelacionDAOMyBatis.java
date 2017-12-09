/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.eci.pdsw.samples.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.pdsw.samples.entities.SolicitudCancelacion;

import edu.eci.pdsw.samples.dao.ConsultaSolicitudCancelacionDAO;
import edu.eci.pdsw.samples.dao.PersistenceException;
import edu.eci.pdsw.samples.dao.mybatis.mappers.ConsultaSolicitudCancelacionMapper;
import edu.eci.pdsw.samples.entities.Estudiante;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cesar
 */
public class ConsultaSolicitudCancelacionDAOMyBatis implements ConsultaSolicitudCancelacionDAO{
    
    private List<SolicitudCancelacion> groupCancelacionees;
    private Estudiante estu1;
    @Inject
    ConsultaSolicitudCancelacionMapper conMap;

    @Override
    public List<SolicitudCancelacion> Read() throws PersistenceException {
        try {
            groupCancelacionees=conMap.loadSolictudCancelacion();
            
        } catch (Exception ex) {
            throw new PersistenceException("Error al solicitar los registros de solicitudes",ex);
        }
        return groupCancelacionees;   
    }
    
    @Override
    public Estudiante loadestud(String nombre)throws PersistenceException{
        System.out.println("llegamos?");
        
        //System.out.println("Que imprime"+estu1.getNombre());
        return conMap.loadestud(nombre);
        
            
        
    }
    
    
}
