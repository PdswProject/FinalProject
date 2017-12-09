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
import java.io.PrintWriter;
import java.util.ArrayList;
/**
 *
 * @author USER
 */
@ManagedBean(name = "SolicitudesEstudiantes")
@SessionScoped
public class SolicitudCancelacionBean implements Serializable{
 
    
    //private  ServiciosCancelaciones scm =ServiciosCancelacionesFactory.getInstance().getServiciosCancelaciones();    
    
    Asignatura asignatura=new Asignatura(0, 0);
    List<Asignatura> listaAsignaturasPE=new LinkedList<>();
    private int codigo=0;
    String nombreAsignatura="";
    private int creditos=0;
    int idEstudiante=0;
    String nombre="";
    String apellido="";
    int creditosAprobados=0;
    //Asignatura[] materiasActualesEst;
    List<Asignatura> materiasActualesEst=new ArrayList<>();
    
    private Asignatura[] vistasActualmente;
    private  Asignatura[] asignaturasPlanEstudios;       
    private List<Asignatura> vistasActualmente1;
    private  List<Asignatura> asignaturasPlanEstudios1=new ArrayList<>();       
                
    Estudiante estudiante= new Estudiante();
    
    
    public SolicitudCancelacionBean() {
        materiasActualesEst=new ArrayList<Asignatura>();
        List<Asignatura> asig = new LinkedList<>();
        ProgramaAcademico p1= new ProgramaAcademico(1, "Ingenieria Sistemas", 10, 210, 150);
        Asignatura as1 = new Asignatura(101, "Logica", p1, "Departamento Matematica", 504,3);
        Asignatura as2 = new Asignatura(102, "Modelos", p1, "Departamento Matematica", 505,4);
        Asignatura as3 = new Asignatura(103, "Redes", p1, "Departamento Matematica", 510,3);
        asig.add(as1);
        asig.add(as2);
        asig.add(as3);
        materiasActualesEst.add(as1);
        materiasActualesEst.add(as2);
        materiasActualesEst.add(as3);    
        asignaturasPlanEstudios1.add(as1);
        asignaturasPlanEstudios1.add(as2);
        asignaturasPlanEstudios1.add(as3);
                
        //Asignatura[] asignaturasPlanEstudios = new Asignatura[3];
        //asignaturasPlanEstudios1.add(as1);
        //asignaturasPlanEstudios1.add(as2);
        //asignaturasPlanEstudios1.add(as3);
        //for (int i=0;i<asig.size();i++){
        //    asignaturasPlanEstudios[i] = asig.get(i);
        //} 
        //vistasActualmente[0]= as1;
        
        //vistasActualmente[1]= as2;
        //vistasActualmente[2]= as3;
        //vistasActualmente1.add(as1);
        //vistasActualmente1.add(as2);
        //vistasActualmente1.add(as3);
        //PlanEstudios plan= new PlanEstudios(1, 3, p1, asig);
        estudiante = new Estudiante(2104481, "daniel", "cas", 6,p1,1,78, 001, 313, 9, asig);
        //ServiciosCancelacionesImpl re= new ServiciosCancelacionesImpl();
        //re.cargarDatosPrueba();
        //re.cargarDatosPrueba();
    
        //materiasActualesEst=scm.verMateriasActuales(estudiante);
        
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

    //public Asignatura[] getMateriasActualesEst() {
    public List<Asignatura> getMateriasActualesEst() {
        return materiasActualesEst;
    }
    public List<String> getNombreMateriasActualesEst() {
        List<String> nuev= new ArrayList<>();
        Asignatura temp;
        for (int i =0; i<materiasActualesEst.size(); i++ ){
            temp=materiasActualesEst.get(i);
            nuev.add(temp.getNombre());
        }
        return nuev;
    }
    //public void setMateriasActualesEst(Asignatura[] materiasActualesEst) {
    public void setMateriasActualesEst(List<Asignatura> materiasActualesEst) {
        this.materiasActualesEst = materiasActualesEst;
    }
    
    public List<SolicitudCancelacion> getListCancelacion() throws ExcepcionSolicitudes{
        //return scm.getSolicitudCancelacion();
        return new ArrayList<>();
    }


    public int calcularImpacto(Estudiante estudiante, Asignatura[] vistasActualmente) throws ExcepcionSolicitudes{
        //return scm.calcularImpacto(estudiante, vistasActualmente);
        return 0;
    }   
}