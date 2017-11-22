/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.eci.pdsw.finalproject.mybatis;

import com.google.inject.Inject;
import edu.eci.pdsw.finalproject.entities.SolicitudCancelacion;
import edu.eci.pdsw.finalproject.mybatis.mappers.ConsultaSolicitudCancelacionMapper;
import edu.eci.pdsw.finalproject.persistence.ConsultaSolicitudCancelacionDAO;
import edu.eci.pdsw.finalproject.persistence.PersistenceException;
import java.util.List;

/**
 *
 * @author cesar
 */
public class ConsultaSOlicitudCancelacionMyBatis implements ConsultaSolicitudCancelacionDAO{
    
    private List<SolicitudCancelacion> groupCancelacionees;
    @Inject
    ConsultaSolicitudCancelacionMapper conMap;

    @Override
    public List<SolicitudCancelacion> Read() throws PersistenceException {
        
        try {

            groupCancelacionees=conMap.getSolictudCancelacion();
            
        } catch (Exception ex) {
            throw new PersistenceException("Error al solicitar los registros de solicitudes",ex);
        }
        return groupCancelacionees;

   
    }
    
    
    
}
