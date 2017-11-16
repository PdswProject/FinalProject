/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.finalproject.mybatis;

import com.google.inject.Inject;
import edu.eci.pdsw.finalproject.entities.ProgramaAcademico;
import edu.eci.pdsw.finalproject.mybatis.mappers.DecanoMapper;
import edu.eci.pdsw.finalproject.persistence.DecanoDAO;
import edu.eci.pdsw.finalproject.persistence.PersistenceException;

/**
 *
 * @author DANIEL
 */
public class DecanoDAOMyBatis implements DecanoDAO{
    
    @Inject
    DecanoMapper dMap;
    
    @Override
    public void update(int num) throws PersistenceException {
        try {
            if (num > 0){
                dMap.actualizarNumeroCreditos(num);
            }
        } catch (Exception ex) {
            throw new PersistenceException("Error al actualizar el numero de creditos",ex);
        }
    }
}
