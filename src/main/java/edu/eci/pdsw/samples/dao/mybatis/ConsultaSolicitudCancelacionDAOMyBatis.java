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
import java.util.List;

/**
 *
 * @author cesar
 */
public class ConsultaSolicitudCancelacionDAOMyBatis implements ConsultaSolicitudCancelacionDAO{
    
    private List<SolicitudCancelacion> groupCancelacionees;
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
    
    
    
}
