/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.pdsw.samples.dao.ConsejeroDAO;
import edu.eci.pdsw.samples.dao.mybatis.mappers.ConsejeroMapper;
import edu.eci.pdsw.samples.entities.Consejero;
import edu.eci.pdsw.samples.entities.Estudiante;
import edu.eci.pdsw.samples.entities.SolicitudCancelacion;
import java.util.List;

/**
 *
 * @author DANIEL
 */
public class ConsejeroDAOMyBatis implements ConsejeroDAO{

    @Inject
    ConsejeroMapper conmap;

    
    @Override
    public Consejero loadByConsejero(String nombre) {
        Consejero resp=conmap.loadByConsejero(nombre);
        return resp;
    }

    @Override
    public List<SolicitudCancelacion> loadAllSolicitud(int num) {
        List<SolicitudCancelacion> resp=conmap.loadAllSolicitud(num);
        return resp;
    }
    

    
}
