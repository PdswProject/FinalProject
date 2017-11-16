/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.finalproject.services.impl;

import edu.eci.pdsw.finalproject.entities.*;
import edu.eci.pdsw.finalproject.services.ExcepcionSolicitudes;
import edu.eci.pdsw.finalproject.services.Solicitudes;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 *
 * @author 2104481
 */
public final class SolicitudesCancelaciones implements Solicitudes{
    
    private final Map<Tupla<Integer, String>, Estudiante> estudiantes;
    private final List<Asignatura> asignaturasPlanEstudios;
    private final List<Asignatura> vistasActualmente;
    

    public SolicitudesCancelaciones(){
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
     * @param asig The subject that you want cancel.
     * @param e The student.
     * @return The number of credit that will be pending.
     * @throws edu.eci.pdsw.finalproject.services.ExcepcionSolicitudes si el estudiante o la asignatura no existen
     */
    @Override
    public int calcularImpacto(Estudiante e, Asignatura asig) throws ExcepcionSolicitudes{
        return 0;

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
    @Override
    public List<Asignatura> verMateriasActuales(Estudiante e) throws ExcepcionSolicitudes{
        throw new ExcepcionSolicitudes("No implementado aun");
    }


    @Override
    public void solicitarCancelacion(Estudiante e, Asignatura a, String justificacion) throws ExcepcionSolicitudes {
       //Solicitudes mater= new SolicitudesImpl(e,a,justificacion, 9); 
        int rep=calcularImpacto(e, a);
        
    }

    @Override
    public void ajustarMaxCreditosSemestre(int numcreditos) throws ExcepcionSolicitudes {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        Asignatura a4 =new Asignatura(0, "materia4", new ProgramaAcademico(), "pajarito", 1, 3);
        Asignatura a5 =new Asignatura(0, "materia5", new ProgramaAcademico(), "pajarito", 1, 3);
        Asignatura a3 =new Asignatura(0, "materia3", new ProgramaAcademico(), "pajarito", 1, 4,Arrays.asList(a5));
        Asignatura a2 =new Asignatura(0, "materia2", new ProgramaAcademico(), "pajarito", 1, 2,Arrays.asList(a3,a4));
        
        PlanEstudios pe=new PlanEstudios(1, 5, new ProgramaAcademico(),Arrays.asList(a1,a2,a3,a4,a5));
        
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
