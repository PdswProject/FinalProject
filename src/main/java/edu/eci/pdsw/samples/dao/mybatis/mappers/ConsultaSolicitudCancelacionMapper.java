/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.eci.pdsw.samples.dao.mybatis.mappers;

import edu.eci.pdsw.samples.entities.SolicitudCancelacion;
import edu.eci.pdsw.samples.entities.Estudiante;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author cesar
 */
public interface ConsultaSolicitudCancelacionMapper {
        public List<SolicitudCancelacion> loadSolictudCancelacion();
        public Estudiante loadestud(@Param("nomb") String nombre);
    
}
