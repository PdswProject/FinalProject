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
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author cesar
 */
public class ConsultaSolicitudCancelacionDAOMyBatis implements ConsultaSolicitudCancelacionDAO{
    
    private List<SolicitudCancelacion> groupCancelacionees;
    private List<Estudiante> estudiantes;
    //private Estudiante estu1;
    private String prueb;
    private SqlSession sqlss;
     ConsultaSolicitudCancelacionMapper equmapper = null;
    @Inject
    ConsultaSolicitudCancelacionMapper conMap;
    public ConsultaSolicitudCancelacionDAOMyBatis() {
    }
    public ConsultaSolicitudCancelacionDAOMyBatis(SqlSession session) {
        this.sqlss = session;
        equmapper = session.getMapper(ConsultaSolicitudCancelacionMapper.class);
    }

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
    public Estudiante loadEstudEspecific(String nombre){
        System.out.println("llegamos?");
        System.out.println("Erick es una loca v2");

        Estudiante estu1=conMap.loadEstudEspecific(nombre);

        System.out.println("Que imprime"+estu1.getNombre());
        return conMap.loadEstudEspecific(nombre);        
    }
    @Override
    public List<Estudiante> loadAll() {
        estudiantes=conMap.loadAll();
        System.out.println("que retorna");
        for(int i=0;i<estudiantes.size();i++){
            Estudiante re=estudiantes.get(i);
            System.out.println("que retorna"+re.getNombre());
        }
        
        return estudiantes;
  
    }
    
    
    
}
