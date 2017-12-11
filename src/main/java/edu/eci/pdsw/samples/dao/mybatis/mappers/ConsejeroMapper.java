/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.dao.mybatis.mappers;

import edu.eci.pdsw.samples.entities.Consejero;
import edu.eci.pdsw.samples.entities.SolicitudCancelacion;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author DANIEL
 */
public interface ConsejeroMapper {
    
    public Consejero loadByConsejero(@Param("doc")String nombre);
    public List<SolicitudCancelacion> loadAllSolicitud(@Param("num")int num);
}
