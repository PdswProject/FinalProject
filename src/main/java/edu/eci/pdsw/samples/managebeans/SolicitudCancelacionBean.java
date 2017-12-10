/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managebeans;

import edu.eci.pdsw.samples.dao.PersistenceException;
import edu.eci.pdsw.samples.dao.mybatis.ConsultaSolicitudCancelacionDAOMyBatis;
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
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
/**
 *
 * @author USER
 */
@ManagedBean(name = "SolicitudesEstudiantes")
@SessionScoped
//@RequestScoped
public class SolicitudCancelacionBean implements Serializable{
 
    @ManagedProperty(value="#{loginBean}")    
    private ShiroLoginBean loginBean;
    
    private  ServiciosCancelaciones scm;
    Asignatura asignatura=new Asignatura(0, 0);
    List<Asignatura> listaAsignaturasPE=new LinkedList<>();
    private int codigo=0;
    String nombreAsignatura="";
    private int creditos=0;
    int idEstudiante=0;
    String apellido="";
    int creditosAprobados=0;
    List<Asignatura> materiasActualesEst=new ArrayList<>();
    private PlanEstudios plane;
    private List<Asignatura> vistasActualmente;
    private  List<Asignatura> asignaturasPlanEstudios=new ArrayList<>();       
    String nombre;        
    Estudiante estudiante= new Estudiante();

    public SolicitudCancelacionBean() throws PersistenceException, ExcepcionSolicitudes{   
        //Nombre=getUser();
        System.out.println("QUE VOY A CONSULTAR LA ERICK "+nombre);
        ServiciosCancelaciones scm =ServiciosCancelacionesFactory.getInstance().getServiciosCancelaciones();    
        List<Estudiante> Listpru=scm.getAllEstudiantes();
        //String prue2=getUser();
        //System.out.println("QUE VOY A CONSULTAR LA ERICK "+prue2);
        //asignaturasPlanEstudios

        
        
        
        //plane=scm.extraerPlanEstudios(re);
        //vistasActualmente=plane.getMaterias();

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
        asignaturasPlanEstudios.add(as1);
        asignaturasPlanEstudios.add(as2);
        asignaturasPlanEstudios.add(as3);
        

        
        //List<Asignatura> asig =re.getMateriaActual();
        //ProgramaAcademico p1= re.getProgramaAcademico();
        estudiante=scm.loadEstudEspecific("Nicolas");
        //List<Asignatura> qqq=scm.allByEstud(estudiante.getId());
        /**
        List<Asignatura> qqq=scm.allAsig();
        for(int i=0; i<qqq.size();i++){
            Asignatura ui=qqq.get(i);
            System.out.println("que imprime"+ui.getNombre());
        }
        */
        //estudiante = new Estudiante(2104481, "daniel", "cas", 6,p1,1,78, 001, 313, 9, asig);
        //ServiciosCancelacionesImpl re= new ServiciosCancelacionesImpl();
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

    public String getUser(){
        String Nombre1=loginBean.getUsername();
        return Nombre1;
    
    }
    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }
    public void setUser(String nombre){
        this.nombre=nombre;

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

    /**
     * @return the bean
     */
    public ShiroLoginBean getloginBean() {
        return loginBean;
    }

    /**
     * @param bean the bean to set
     */
    public void setloginBean(ShiroLoginBean beana) {
        this.loginBean = beana;
    }
}