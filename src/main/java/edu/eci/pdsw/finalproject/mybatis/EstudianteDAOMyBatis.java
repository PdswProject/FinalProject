/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.finalproject.mybatis;

import com.google.inject.Inject;
import edu.eci.pdsw.finalproject.entities.Asignatura;
import edu.eci.pdsw.finalproject.mybatis.mappers.EstudianteMapper;
import edu.eci.pdsw.finalproject.persistence.EstudianteDAO;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author DANIEL
 */
public class EstudianteDAOMyBatis implements EstudianteDAO{
    @Inject
    EstudianteMapper eMap;
    
    @Override
    public List<Asignatura> loadAll() throws PersistenceException {
        try {
            return eMap.loadAsignaturas();
        } catch (Exception ex) {
            throw new PersistenceException("Error al cargar las asignaturas",ex);
        }
    }
}
