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
@ManagedBean(name = "SolicitudesEstudiantes", eager=true)
//@SessionScoped
@RequestScoped
public final class SolicitudCancelacionBean implements Serializable{
 
    @ManagedProperty(value="#{loginBean}")    
    private ShiroLoginBean logBen;
    private String username;
    //
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

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
    String comentarios="";
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

    public boolean isValue1() {
        return value1;
    }

    public void setValue1(boolean value1) {
        this.value1 = value1;
    }
    private boolean value1;
    private List<Integer> prueb;
    private String justificacion;
    @Inject
    private CalculadorDeImpactoSimple calcu; 
    private Asignatura[] salva;
    //Temporal
    private int ressp;
    private Acudiente ds;
    private String correo;
    public SolicitudCancelacionBean() throws PersistenceException, ExcepcionSolicitudes, MessagingException{   
        salva= new Asignatura[10];
        justificacion="";
        prueb=new ArrayList<Integer>();
        prueb.add(1);
        materiasCancelar=new ArrayList<Asignatura>();//Queda fin
        this.scm=ServiciosCancelacionesFactory.getInstance().getServiciosCancelaciones();    ;
        
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
        ds=new Acudiente("Pepino", 989, 10003,"pepino@mail.com");
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
        //calcularImpacto(estudiante,salva, planer);
        //sendMessage();
        //List<Asignatura> qqq=scm.allAsig();
        for(int i=0; i<materiasActualesEst.size();i++){
            Asignatura ui=materiasActualesEst.get(i);
            System.out.println("que imprime"+ui.getNombre());
            System.out.println("que imprime de codigo"+ui.getCodigo());
            System.out.println("que imprime de creditos"+ui.getCreditos());
        }
        
    }
    
    
    
    //Envio Mensaje
    public void sendMessage(String correo)throws ExcepcionSolicitudes, MessagingException{
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

    public Estudiante getEstudiante() throws ExcepcionSolicitudes, MessagingException{
        String gu=getUser();
        
        return scm.loadEstudEspecific(gu);
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
    
    public void getSendCorreoAcudiente() throws ExcepcionSolicitudes, MessagingException{
        sendMessage(GetCorreoAcudiente());
    
    }
    
    public void setCorreoAcudiente(String corrreo){
        this.correo=correo;
        
    }
    public String GetCorreoAcudiente(){
        return correo;
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
    
    public List<Asignatura> getMateriasActualesEst() throws ExcepcionSolicitudes {
        //materiasActualesEst=scm.allByEstud(estudiante.getId());
        String gu=getUser();
        Estudiante re=scm.loadEstudEspecific(gu);

        return scm.allByEstud(re.getId());
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



    public int getCalcularImpacto(Estudiante e ,List<Asignatura> vistasActualmente) throws ExcepcionSolicitudes{
        //respCalc=0+calcu.calcularImpacto(vistasActualmente, plane);
        //respCalc=scm.calcularImpacto(e, (Asignatura[]) vistasActualmente.toArray());
        System.out.println("que imprime"+respCalc);
        respCalc=0;
        return respCalc;
    }   

    public int getCalcularImpacto()throws ExcepcionSolicitudes{      
        String gu=getUser();
        Estudiante re=scm.loadEstudEspecific(gu);
        List<Asignatura> rer=scm.verMateriasActuales(re);
        
        respCalc=getCalcularImpacto(re,rer);
    
        return respCalc;
    }


    /**
     * @return the bean
     */
    public ShiroLoginBean getLogBen() {
        return logBen;
    }

    /**
     * @param bean the bean to set
     */
    
    public void setLogBen(ShiroLoginBean beana) {
        this.logBen = beana;
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
    
    public String getUser(){
        username=logBen.getUsername();
        return username;
    }

}