/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.dao;

import java.util.List;
import edu.eci.pdsw.samples.entities.Asignatura;

/**
 *
 * @author DANIEL
 */
public interface EstudianteDAO {
    public List<Asignatura> loadAll() throws PersistenceException;

}
