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
import edu.eci.pdsw.samples.entities.Estudiante;
import java.util.Date;

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

    @Override
    public void solicitudCancelacion(int id, Estudiante e, int condAsignatuea, Date fecha, String estado, int decano_id, String Justificacion) throws PersistenceException {
        eMap.solicitudCancelacion(id, e, condAsignatuea, fecha, estado, decano_id, Justificacion);
               
        
    }
}
