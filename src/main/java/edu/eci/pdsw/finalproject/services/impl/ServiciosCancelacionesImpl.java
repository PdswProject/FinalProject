/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.finalproject.services.impl;

import com.google.inject.Inject;
import edu.eci.pdsw.finalproject.entities.*;

import edu.eci.pdsw.finalproject.entities.Asignatura;
import edu.eci.pdsw.finalproject.entities.Estudiante;
import edu.eci.pdsw.finalproject.entities.PlanEstudios;
import edu.eci.pdsw.finalproject.entities.ProgramaAcademico;
import edu.eci.pdsw.finalproject.services.CalculadorDeImpacto;

import edu.eci.pdsw.finalproject.persistence.DecanoDAO;
import edu.eci.pdsw.finalproject.persistence.EstudianteDAO;

import edu.eci.pdsw.finalproject.services.ExcepcionSolicitudes;
import edu.eci.pdsw.finalproject.services.ServiciosCancelaciones;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.mybatis.guice.transactional.Transactional;
import edu.eci.pdsw.finalproject.persistence.PersistenceException;
import edu.eci.pdsw.finalproject.services.ExcepcionSolicitudes;
import java.util.Set;


/**
 *
 * @author 2104481
 */
public final class ServiciosCancelacionesImpl implements ServiciosCancelaciones{
    
    @Inject
    private DecanoDAO d;
    
    @Inject
    private EstudianteDAO de;
     
    
    private final Map<Tupla<Integer, String>, Estudiante> estudiantes;
    private final List<Asignatura> asignaturasPlanEstudios;
    private final List<Asignatura> vistasActualmente;
    
//<<<<<<< HEAD

//=======
    @Inject
    private CalculadorDeImpacto calculadorDeImpacto;       
        
    
//>>>>>>> 3d14d84ef9be0b08471480b8eca6c9d645195472
    public ServiciosCancelacionesImpl(){
        this.estudiantes = new LinkedHashMap<>();
        asignaturasPlanEstudios = new LinkedList<>();
        vistasActualmente= new LinkedList<>();
        cargarDatosPrueba();
        cargarDatosEstaticosGrafo();

    }        
    
    /**
     * Algoritmo de cálculo de impacto que se limita
       a indicar, dado el estudiante y la asignatura a cancelar, 
       cuantos créditos académicos tendría pendiente por ver.
     * @param e The student.
     * @param materia The subject that you want cancel.
     * @throws edu.eci.pdsw.finalproject.services.ExcepcionSolicitudes si el estudiante o la asignatura no existen
     * @return the int
     */
    public int calcularImpacto(Asignatura asig, PlanEstudios plan) throws ExcepcionSolicitudes{
        return calculadorDeImpacto.calcularImpacto(asig, null);
    }    
    /**
     * Extrae el plan de estudios del estudiante
     * @param e
     * @return 
     */
    @Override
    public PlanEstudios extraerPlanEstudios(Estudiante e){
        return null;
    }
    
    /**
     * El sistema debe permitir seleccionar sólo 
     * aquellas asignaturas que esté actualmente 
     * viendo el usuario.
     * @param e
     * @return List of Asignatura.
     * @throws edu.eci.pdsw.finalproject.services.ExcepcionSolicitudes
     */
    @Transactional
    @Override
    public List<Asignatura> verMateriasActuales(Estudiante e) throws ExcepcionSolicitudes{
        return e.getMateriaActual();
    }


    @Override
    public void solicitarCancelacion(Estudiante e, Asignatura a, String justificacion,String estado) throws ExcepcionSolicitudes {
        //Solicitudes mater= new SolicitudesImpl(e,a,justificacion, 9); 
        //Calcular el impacto, despues crear una solcitud cancelacion
        int resSc=calculadorDeImpacto.calcularImpacto(a, null);
        SolicitudCancelacion new2=new SolicitudCancelacion(justificacion, a, null, estado);
        //int rep=calcularImpacto(e, a);
        
    }

    @Transactional
    @Override
    public void ajustarMaxCreditosSemestre(int numcreditos) throws ExcepcionSolicitudes {
        try {
            d.update(numcreditos);
        } catch (PersistenceException ex) {
            System.err.println(ex);
            throw new ExcepcionSolicitudes("No fue posible agregar los creditos");
        }
    }

    @Override
    public void agregarMateria(String programa, int plan, Asignatura a) throws ExcepcionSolicitudes {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarMateria(String programa, int plan, Asignatura a) throws ExcepcionSolicitudes {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean validarPlanEstudios(PlanEstudios pe) throws ExcepcionSolicitudes {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Asignatura> getAsignaturasPlanEstudios() {
        return asignaturasPlanEstudios;
    }

    public List<Asignatura> getVistasActualmente() {
        return vistasActualmente;
    }
    
    
    public void cargarDatosPrueba(){
        
        ProgramaAcademico p1= new ProgramaAcademico(1, "Ingenieria Sistemas", 10, 210, 150);
      
        Asignatura as1 = new Asignatura(101, "Logica", p1, "Departamento Matematica", 504,3);
        Asignatura as2 = new Asignatura(102, "Modelos", p1, "Departamento Matematica", 505,4);
        Asignatura as3 = new Asignatura(103, "Redes", p1, "Departamento Matematica", 510,3);
        
        asignaturasPlanEstudios.add(as1);
        asignaturasPlanEstudios.add(as2);
        asignaturasPlanEstudios.add(as3);
        
        vistasActualmente.add(as1); 
        
        PlanEstudios plan= new PlanEstudios(1, 3, p1, asignaturasPlanEstudios);
        
        Estudiante est= new Estudiante(2104481, "daniel", "cas", 6,78, 001, 313, 9, vistasActualmente);

    }
    private void cargarDatosEstaticosGrafo()
    {
        
        
        Asignatura a1 =new Asignatura(0, "materia1", new ProgramaAcademico(), "pajarito", 1, 4);
        Asignatura a4 =new Asignatura(1, "materia4", new ProgramaAcademico(), "pajarito", 1, 3);
        Asignatura a5 =new Asignatura(2, "materia5", new ProgramaAcademico(), "pajarito", 1, 3);
        Asignatura a3 =new Asignatura(3, "materia3", new ProgramaAcademico(), "pajarito", 1, 4,Arrays.asList(a5));
        Asignatura a2 =new Asignatura(4, "materia2", new ProgramaAcademico(), "pajarito", 1, 2,Arrays.asList(a3,a4));
        
        PlanEstudios pe=new PlanEstudios(1, 5, new ProgramaAcademico(),Arrays.asList(a1,a2,a3,a4,a5));
        
    }

    @Override
    public int calcularImpacto(Estudiante e, Asignatura asig) throws ExcepcionSolicitudes {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }

class Tupla<A, B> {

    A a;
    B b;

    public Tupla(A a, B b) {
        this.a = a;
        this.b = b;
    }

    public A getA() {
        return a;
    }

    public B getB() {
        return b;
    }

    @Override
    public int hashCode() {
        return a.hashCode() + b.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Tupla<?, ?>) {
            return ((Tupla<?, ?>) obj).getA().equals(this.getA())
                    && ((Tupla<?, ?>) obj).getB().equals(this.getB());
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Touple:(" + a.toString() + "," + b.toString() + ")";
    }
}
