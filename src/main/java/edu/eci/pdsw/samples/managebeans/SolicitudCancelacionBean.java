/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managebeans;

import edu.eci.pdsw.samples.entities.Asignatura;
import edu.eci.pdsw.samples.entities.Estudiante;
import edu.eci.pdsw.samples.entities.PlanEstudios;
import edu.eci.pdsw.samples.entities.ProgramaAcademico;
import edu.eci.pdsw.samples.entities.SolicitudCancelacion;
import edu.eci.pdsw.samples.services.ExcepcionSolicitudes;
import edu.eci.pdsw.samples.services.ServiciosCancelacionesFactory;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import edu.eci.pdsw.samples.services.ServiciosCancelaciones;
import edu.eci.pdsw.samples.services.impl.ServiciosCancelacionesImpl;
import java.util.ArrayList;
/**
 *
 * @author USER
 */

@ManagedBean(name = "SolicitudesEstudiantes")
@SessionScoped

public class SolicitudCancelacionBean implements Serializable{
    private final ServiciosCancelaciones scm =ServiciosCancelacionesFactory.getInstance().getServiciosCancelaciones();
    private Asignatura asignatura;
    List<Asignatura> listaAsignaturasPE=new LinkedList<>();
    private int codigo;
    String nombreAsignatura;
    private int creditos;
   
    int idEstudiante;
    String nombre;
    String apellido;
    int creditosAprobados;
    List<Asignatura> materiasActualesEst;
    
    private List<Asignatura> vistasActualmente;
    private List<Asignatura> asignaturasPlanEstudios;       
        
    private Estudiante estudiante;
    //estudiante=
    
    public SolicitudCancelacionBean()throws ExcepcionSolicitudes{
        asignaturasPlanEstudios = new LinkedList<>();
        vistasActualmente= new LinkedList<>();
        ProgramaAcademico p1= new ProgramaAcademico(1, "Ingenieria Sistemas", 10, 210, 150);
        Asignatura as1 = new Asignatura(101, "Logica", p1, "Departamento Matematica", 504,3);
        Asignatura as2 = new Asignatura(102, "Modelos", p1, "Departamento Matematica", 505,4);
        Asignatura as3 = new Asignatura(103, "Redes", p1, "Departamento Matematica", 510,3);
        asignaturasPlanEstudios.add(as1);
        asignaturasPlanEstudios.add(as2);
        asignaturasPlanEstudios.add(as3);
        vistasActualmente.add(as1); 
        vistasActualmente.add(as2);
        vistasActualmente.add(as3);
        
        PlanEstudios plan= new PlanEstudios(1, 3, p1, asignaturasPlanEstudios);

        this.estudiante = new Estudiante(2104481, "daniel", "cas", 6,78, 001, 313, 9, vistasActualmente);
        ServiciosCancelacionesImpl re= new ServiciosCancelacionesImpl();
        re.cargarDatosPrueba();
        //re.ca
        //null pointer estudiante no asignado
        System.out.println("ERIC ERS UNA LOCA"+estudiante.getNombre()+"Y LO CONFIMRA-----------------||||---|-|-|-|--|");
        materiasActualesEst=scm.verMateriasActuales(estudiante);
        
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
    
    

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

   

    public List<Asignatura> getListaAsignaturasPE() {
        return listaAsignaturasPE;
    }

    public void setListaAsignaturasPE(List<Asignatura> listaAsignaturasPE) {
        this.listaAsignaturasPE = listaAsignaturasPE;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCreditosAprobados() {
        return creditosAprobados;
    }

    public void setCreditosAprobados(int creditosAprobados) {
        this.creditosAprobados = creditosAprobados;
    }

    public List<Asignatura> getMateriasActualesEst() {
        return materiasActualesEst;
    }
    public List<String> getNombreMateriasActualesEst() {
        List<String> nuev= new ArrayList<String>();
        Asignatura temp;
        for (int i =0; i<materiasActualesEst.size(); i++ ){
            temp=materiasActualesEst.get(i);
            nuev.add(temp.getNombre());
        }
        return nuev;
    }
    public void setMateriasActualesEst(List<Asignatura> materiasActualesEst) {
        this.materiasActualesEst = materiasActualesEst;
    }
    
    public List<SolicitudCancelacion> getListCancelacion() throws ExcepcionSolicitudes{
        
        return scm.getSolicitudCancelacion();

    }

    public ServiciosCancelaciones getScm() {
        return scm;
    }
    
}
