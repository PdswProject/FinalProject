/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.entities;

import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;

/**
 *
 * @author USER
 */
public class Consejero {
    
    private List<Estudiante> listaEstudiantes;
    private String Nombre;
    private Asignatura materiaAsignada;//Esta no se bien
    private String comentarios;
    private int id;
    private boolean aval;
    public Consejero(){}
    public Consejero(boolean aval,String Nombre, String Comentarios){
        this.aval=aval;
        listaEstudiantes=new ArrayList<Estudiante>();
        this.Nombre=Nombre;
        this.comentarios=Comentarios;

    }
    public List<Estudiante> getListEstudiante(){
        return listaEstudiantes;
    }
    public void setListaEstudiantes(List<Estudiante> est){
        listaEstudiantes=est;
    }
    
    public String getNombre(){
        return Nombre;
    }
    public void setNombre(String no){
        Nombre=no;
    }
    
    public String getComentarios(){
        return comentarios;
    }
    
    public void setComentarios(String co){
        comentarios=co;
    
    }
    
    public int getId(){
        return id;
    }
    public void setId(int id){
            this.id=id;
    }
    public Boolean getBoolean(){
        return aval;
    }
    public void setBoolean(Boolean bo){
        aval=bo;
    }
    
    
    
}
