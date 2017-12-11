/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.eci.pdsw.samples.managebeans;

import edu.eci.pdsw.samples.entities.Consejero;
import edu.eci.pdsw.samples.entities.SolicitudCancelacion;
import edu.eci.pdsw.samples.services.ExcepcionSolicitudes;
import edu.eci.pdsw.samples.services.ServiciosCancelaciones;
import edu.eci.pdsw.samples.services.ServiciosCancelacionesFactory;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author cesar
 */
@ManagedBean(name = "ConsejeroEstudiantes")
@SessionScoped
public final class ConsejeroSolicutdBean implements Serializable{

    private  ServiciosCancelaciones scm;
    private Consejero actual;
    private String nombre;
    private List<SolicitudCancelacion> sol;

    public ConsejeroSolicutdBean() throws ExcepcionSolicitudes {
        ServiciosCancelaciones scm =ServiciosCancelacionesFactory.getInstance().getServiciosCancelaciones();    
        nombre="Gustavo";
        actual= scm.loadByConsejero(nombre);
        System.out.println("IMPRIME"+actual.getNombre());
        sol=scm.loadAllSolicitud(actual.getId());
        
    }
    
    public Consejero getConsejero(){
        return actual;
    }
    public void setConsejero(Consejero co){
        actual=co;
    }
    
    public String getNombreCons(){
        return actual.getNombre();
    }
    
    public Integer getIdCons(){
        return actual.getId();
    }    
    
    public List<SolicitudCancelacion> getSol(){
        return sol;
    }
    public void setSol(List<SolicitudCancelacion> sole){
        sol=sole;
    }
    
    
    
    
    
    
    
}

