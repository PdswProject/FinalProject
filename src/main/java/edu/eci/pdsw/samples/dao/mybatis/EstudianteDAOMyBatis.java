/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.pdsw.samples.entities.Asignatura;

import edu.eci.pdsw.samples.dao.EstudianteDAO;
import java.util.List;
import edu.eci.pdsw.samples.dao.PersistenceException;
import edu.eci.pdsw.samples.dao.mybatis.mappers.EstudianteMapper;

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
