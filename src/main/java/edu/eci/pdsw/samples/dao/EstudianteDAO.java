/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.dao;

import java.util.List;
import edu.eci.pdsw.samples.entities.Asignatura;
import edu.eci.pdsw.samples.entities.Estudiante;
import java.util.Date;

/**
 *
 * @author DANIEL
 */
public interface EstudianteDAO {
    public List<Asignatura> loadAll() throws PersistenceException;
    public void solicitudCancelacion(int id, Estudiante e, int condAsignatuea, Date fecha, String estado, int decano_id, String Justificacion)throws PersistenceException;
}
