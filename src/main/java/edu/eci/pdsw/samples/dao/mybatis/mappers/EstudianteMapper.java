/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.dao.mybatis.mappers;

import java.util.List;
import edu.eci.pdsw.samples.entities.Asignatura;
import edu.eci.pdsw.samples.entities.Estudiante;
import java.util.Date;
import org.apache.ibatis.annotations.Param;
/**
 *
 * @author DANIEL
 */
public interface EstudianteMapper {
    public List<Asignatura> loadAsignaturas();
    public void solicitudCancelacion(@Param("id") int id, @Param("estu")Estudiante e, @Param("conasi") int condAsignatuea, @Param ("dat")Date fecha, @Param("est")String estado, @Param("dec") int decano_id, @Param("jus") String Justificacion);

}
