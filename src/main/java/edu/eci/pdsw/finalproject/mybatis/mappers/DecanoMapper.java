/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.finalproject.mybatis.mappers;

import org.apache.ibatis.annotations.Param;

/**
 *
 * @author DANIEL
 */
public interface DecanoMapper {
    public void actualizarNumeroCreditos(@Param("cant") int num); 

}
