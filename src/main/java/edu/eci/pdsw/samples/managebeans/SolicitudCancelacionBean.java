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
    Asignatura asignatura;
    List<Asignatura> listaAsignaturasPE=new LinkedList<>();
    private int codigo;
    String nombreAsignatura;
    private int creditos;
   
    int idEstudiante;
    String nombre;
    String apellido;
    int creditosAprobados;
    Asignatura[] materiasActualesEst;
    
    private Asignatura[] vistasActualmente;
    private  Asignatura[] asignaturasPlanEstudios;       
        
    Estudiante estudiante;
    
    
    public SolicitudCancelacionBean()throws ExcepcionSolicitudes{
        
        List<Asignatura>asig = new LinkedList<>();
        
        ProgramaAcademico p1= new ProgramaAcademico(1, "Ingenieria Sistemas", 10, 210, 150);
        Asignatura as1 = new Asignatura(101, "Logica", p1, "Departamento Matematica", 504,3);
        Asignatura as2 = new Asignatura(102, "Modelos", p1, "Departamento Matematica", 505,4);
        Asignatura as3 = new Asignatura(103, "Redes", p1, "Departamento Matematica", 510,3);
        asig.add(as1);
        asig.add(as2);
        asig.add(as3);
        Asignatura[] asignaturasPlanEstudios = new Asignatura[3];
        
        for (int i=0;i<asig.size();i++){
            asignaturasPlanEstudios[i] = asig.get(i);
        } 
        

        vistasActualmente[0]= as1;
        vistasActualmente[1]= as2;
        vistasActualmente[2]= as3;
 
        
        PlanEstudios plan= new PlanEstudios(1, 3, p1, asignaturasPlanEstudios);
        
        estudiante = new Estudiante(2104481, "daniel", "cas", 6,p1,1,78, 001, 313, 9, vistasActualmente);
        ServiciosCancelacionesImpl re= new ServiciosCancelacionesImpl();
        re.cargarDatosPrueba();
        
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

    public Asignatura[] getMateriasActualesEst() {
        return materiasActualesEst;
    }
    public List<String> getNombreMateriasActualesEst() {
        List<String> nuev= new ArrayList<String>();
        Asignatura temp;
        for (int i =0; i<materiasActualesEst.length; i++ ){
            temp=materiasActualesEst[i];
            nuev.add(temp.getNombre());
        }
        return nuev;
    }
    public void setMateriasActualesEst(Asignatura[] materiasActualesEst) {
        this.materiasActualesEst = materiasActualesEst;
    }
    
    public List<SolicitudCancelacion> getListCancelacion() throws ExcepcionSolicitudes{
        
        return scm.getSolicitudCancelacion();

    }

    public ServiciosCancelaciones getScm() {
        return scm;
    }
    
    public int calcularImpacto(Estudiante estudiante, Asignatura[] vistasActualmente) throws ExcepcionSolicitudes{
        return scm.calcularImpacto(estudiante, vistasActualmente);
    }
    
}
