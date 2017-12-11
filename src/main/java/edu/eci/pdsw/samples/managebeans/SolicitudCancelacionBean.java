/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managebeans;

import com.google.inject.Inject;
import edu.eci.pdsw.samples.dao.PersistenceException;
import edu.eci.pdsw.samples.dao.mybatis.ConsultaSolicitudCancelacionDAOMyBatis;
import edu.eci.pdsw.samples.dao.mybatis.EstudianteDAOMyBatis;
import edu.eci.pdsw.samples.entities.Acudiente;
import edu.eci.pdsw.samples.entities.Asignatura;
import edu.eci.pdsw.samples.entities.Estudiante;
import edu.eci.pdsw.samples.entities.PlanEstudios;
import edu.eci.pdsw.samples.entities.ProgramaAcademico;
import edu.eci.pdsw.samples.entities.SolicitudCancelacion;
import edu.eci.pdsw.samples.mailapp.Email;
import edu.eci.pdsw.samples.mailapp.EmailConfiguration;
import edu.eci.pdsw.samples.mailapp.EmailSender;
import edu.eci.pdsw.samples.mailapp.SimpleEmail;
import edu.eci.pdsw.samples.mailapp.SimpleEmailSender;
import edu.eci.pdsw.samples.services.ExcepcionSolicitudes;
import edu.eci.pdsw.samples.services.ServiciosCancelacionesFactory;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import edu.eci.pdsw.samples.services.ServiciosCancelaciones;
import edu.eci.pdsw.samples.services.impl.CalculadorDeImpactoSimple;
import edu.eci.pdsw.samples.services.impl.ServiciosCancelacionesImpl;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.mail.MessagingException;
/**
 *
 * @author USER
 */
@ManagedBean(name = "SolicitudesEstudiantes")
@SessionScoped
//@RequestScoped
public final class SolicitudCancelacionBean implements Serializable{
 
    @ManagedProperty(value="#{loginBean}")    
    private ShiroLoginBean loginBean;
    
    private final String subject="Cancelacion de asignaturas de su hijo/a";
    private final String message="Su hija va a cancelar las asignaturas ";
    private PlanEstudios plane;
    private  ServiciosCancelaciones scm;
    private CalculadorDeImpactoSimple cdi;
    Asignatura asignatura=new Asignatura(0, 0);
    List<Asignatura> listaAsignaturasPE=new LinkedList<>();
    private int codigo=0;
    String nombreAsignatura="";
    private int creditos=0;
    int idEstudiante=0;
    String apellido="";
    int creditosAprobados=0;
    List<Asignatura> materiasActualesEst=new ArrayList<>();
    private PlanEstudios planer;
    private List<Asignatura> vistasActualmente;
    private  List<Asignatura> asignaturasPlanEstudios=new ArrayList<>();       
    String nombre;        
    int respCalc;
    Estudiante estudiante= new Estudiante();
    private List<Asignatura> materiasCancelar;
    private ProgramaAcademico prog;
    private String nombreAsig;
    
    private List<Integer> prueb;
    private String justificacion;
    @Inject
    private CalculadorDeImpactoSimple calcu; 
    private Asignatura[] salva;
    //Temporal
    private Acudiente ds;
    
    public SolicitudCancelacionBean() throws PersistenceException, ExcepcionSolicitudes, MessagingException{   
        salva= new Asignatura[10];
        justificacion="";
        prueb=new ArrayList<Integer>();
        prueb.add(1);
        materiasCancelar=new ArrayList<Asignatura>();//Queda fin
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
        salva[0]=as1;
        salva[1]=as2;
        salva[2]=as3;
        //asignaturasPlanEstudios.add(as1);
        //asignaturasPlanEstudios.add(as2);
        //asignaturasPlanEstudios.add(as3);
               
        //List<Asignatura> asig =re.getMateriaActual();
        //ProgramaAcademico p1= re.getProgramaAcademico();
        estudiante=scm.loadEstudEspecific("Nicolas");
        
        //List<Asignatura> qqq=scm.allByEstud(estudiante.getId());
        //List<Asignatura> qqq=scm.allAsig();
        ds=new Acudiente("Pepino", 989, 10003,"pepino@mail.com");
        materiasActualesEst=scm.allByEstud(estudiante.getId());
        asignaturasPlanEstudios=scm.allAsig();
        //Creacion Plan de estudios
        
        prog=new ProgramaAcademico(50, "Ingenieria de sistemas", 13, 1999, 999);
        planer=new PlanEstudios(123, 150, prog, asignaturasPlanEstudios);        
        /**
        for(int pp=0;pp<materiasActualesEst.size();pp++){
            Asignatura re=materiasActualesEst.get(pp);
            salva[pp]=re;
        }*/

        salva=materiasActualesEst.toArray(salva);
        calcularImpacto(estudiante,salva, planer);
        sendMessage();
        //List<Asignatura> qqq=scm.allAsig();
        for(int i=0; i<materiasActualesEst.size();i++){
            Asignatura ui=materiasActualesEst.get(i);
            System.out.println("que imprime"+ui.getNombre());
            System.out.println("que imprime de codigo"+ui.getCodigo());
            System.out.println("que imprime de creditos"+ui.getCreditos());
        }
        
        //estudiante = new Estudiante(2104481, "daniel", "cas", 6,p1,1,78, 001, 313, 9, asig);
        //ServiciosCancelacionesImpl re= new ServiciosCancelacionesImpl();
        //re.cargarDatosPrueba();
        //materiasActualesEst=scm.verMateriasActuales(estudiante);
    }
    //Envio Mensaje
    public void sendMessage()throws ExcepcionSolicitudes, MessagingException{
         String from= "escuela@gmail.com";
         String to=ds.getCorreo();
         String subjectr=subject;
         String messager=message;
         Email email=new SimpleEmail(to, subjectr, messager);
         EmailSender sender=new SimpleEmailSender(new EmailConfiguration());
         try{
             sender.send(email);
             System.out.println("Exito al mandar");
 
         }catch (MessagingException es){
             throw new ExcepcionSolicitudes("NO se pudo mandar nada", es);
         }
         
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
    public void setMateriasActualesEst(List<Asignatura> materiasActualesEst) {
        this.materiasActualesEst = materiasActualesEst;
    }
    
    public List<SolicitudCancelacion> getListCancelacion() throws ExcepcionSolicitudes{
        //return scm.getSolicitudCancelacion();
        return new ArrayList<>();
    }



    public void calcularImpacto(Estudiante e ,Asignatura[] vistasActualmente, PlanEstudios plane) throws ExcepcionSolicitudes{
        //respCalc=0+calcu.calcularImpacto(vistasActualmente, plane);
        //respCalc=scm.calcularImpacto(e, vistasActualmente);
        //System.out.println("que imprime"+respCalc);
        //return scm.calcularImpacto(estudiante, vistasActualmente);
        respCalc=0;
       ;
    }   
    public int getCalcularImpacto(){
        return respCalc;
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
    private void setJusti(String justi){
        justificacion=justi;
    }
    private String getJusti(){
        return justificacion;
    }     
    public void enviarJusti() throws PersistenceException {
        Asignatura o=materiasActualesEst.get(1);
        EstudianteDAOMyBatis re=new EstudianteDAOMyBatis();
        re.solicitudCancelacion(estudiante.getId(), estudiante, o.getCodigo(), null, "No aprobado", 1999, "Me fue mal");

    
    }
    
    public void setNombreAsig(String a){
        nombreAsig=a;
    }
    public String getNombreAsig(){
        return nombreAsig;
    }
    
    public void addMateriasCancelar(String asig){
        System.out.println("que imprime"+asig);
        //materiasCancelar.add(asi);
        for(int y=0; y<materiasActualesEst.size();++y){
            Asignatura o=materiasActualesEst.get(y);
            if(asig.equals(o.getNombre())){
                materiasCancelar.add(o);
                System.out.println("QUE MATERIAS CANCELARA"+o.getNombre());
            }

        
        }
    }
    public List<Asignatura> getMateriasCancelar(){
        return materiasCancelar;
    }

}