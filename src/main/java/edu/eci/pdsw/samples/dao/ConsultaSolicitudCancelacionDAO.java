/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.eci.pdsw.samples.dao;

import edu.eci.pdsw.samples.entities.Estudiante;
import edu.eci.pdsw.samples.entities.SolicitudCancelacion;
import java.util.List;

/**
 *
 * @author cesar
 */
public interface ConsultaSolicitudCancelacionDAO {
    // funciones basicas de crud
    public List<SolicitudCancelacion> Read()throws PersistenceException;
    
    public Estudiante loadEstudEspecific(String nombre);
    
    public List<Estudiante> loadAll();
    
    

    
}
