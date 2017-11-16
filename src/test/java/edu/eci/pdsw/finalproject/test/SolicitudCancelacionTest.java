package edu.eci.pdsw.finalproject.test;

import edu.eci.pdsw.finalproject.entities.Asignatura;
import edu.eci.pdsw.finalproject.entities.Estudiante;
import edu.eci.pdsw.finalproject.entities.PlanEstudios;
import edu.eci.pdsw.finalproject.entities.ProgramaAcademico;
import edu.eci.pdsw.finalproject.services.ExcepcionSolicitudes;
import edu.eci.pdsw.finalproject.services.impl.SolicitudesCancelaciones;
import java.util.LinkedList;
import java.util.List;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import org.junit.Test;

public class SolicitudCancelacionTest {
    
    
    /**
     * CLASES DE EQUIVALENCIA PARA METODO CALCULO IMPACTO SIMPLE
     * 
     *         Clase1: Materia ingresada no se encuentra en el plan de estudios (no registrada)
     * 
     *         Resultado: Un valor booleano
     * 
     *         Clase2: Creditos academicos pendientes por ver debe ser menor a creditos totales de programa academico
     * 
     *         Resultado: Un valor booleano True
     *         
     * 
     * CLASES DE EQUIVALENCIA PARA METODO LOAD ASIGNATURAS ACTUALES
     * 
     *         Clase1: Materia actual mostrada debe estar en el plan de estudios
     * 
     *         Resultado: True
     * 
     *         Clase2: La materia debe estar siendo vista por el estudiante
     * 
     *         Resultado: True
     * 
     * CLASES DE EQUIVALENCIA PARA METODO REGISTRO DE JUSTIFICACION
     *         
     *         Clase1: La justificacion es vacia
     * 
     *         Resultado: Una excepcion
     * 
     *         Clase2: La justificacion lleva numeros, puntos y comas
     * 
     *         Resultado: Una excepcion.
     *
     * Condiciones de Frontera
     *         CF1: Cuando recibe una solicitud o argumento invalido.
     *         Resultado:Error- Solicitud o argumento invalido.
     *         CF2: Cuando se recibe una materia invalida.
     *         Resultado:Error-Materia invalida.
     *         CF3: Cuando la justificacion no se almacena correctamente.
     *          Resultado: Error en la persistencia.
     * 
     * 
     * 
     * @throws edu.eci.pdsw.finalproject.services.ExcepcionSolicitudes
     */
    

    
//(int codigo, String nombre, ProgramaAcademico programa, String unidadAcademica, int profesor, int creditos)
    @Test 
    public void MateriaNoEstaRegistradaEnElPlanDeEstudios()throws ExcepcionSolicitudes{
        
        ProgramaAcademico cer = new ProgramaAcademico(101,"Ingenieria Civil",30,18,150);
        List<Asignatura> materiasPlan = new LinkedList<>();
        List<Asignatura> materiasEst = new LinkedList<>();
        
        Asignatura a=new Asignatura(3, "Fisica", cer, "Ciencia", 3, 3);
        Asignatura b=new Asignatura(4, "Logica", cer, "Ciencia", 3, 3);
        
        materiasPlan.add(a);
        materiasPlan.add(b);
        materiasEst.add(a);
        materiasEst.add(b);
        
        Estudiante e = new Estudiante(2104481, "Daniel", "Cast", 6, 70, 001, 19213, 4, materiasEst);
        
        SolicitudesCancelaciones sc = new SolicitudesCancelaciones(); 
        
        Asignatura c=new Asignatura(5, "Quimica", cer, "Ciencia", 3, 3);
        sc.calcularImpacto(e, c);
        int res=0;
        for(Asignatura i:materiasPlan){
            if(i==c){
                res=1;
            }
        System.out.println(res);
        assertEquals(res,0);
        }
       
    }
    
    @Test 
    public void pruebaCreditosPendientesConsistentes() throws ExcepcionSolicitudes{
        SolicitudesCancelaciones sc = new SolicitudesCancelaciones();
        ProgramaAcademico pa = new ProgramaAcademico(101,"Ingenieria Civil",30,18,150);
        Asignatura a=new Asignatura(3, "Fisica", pa, "Ciencia", 3, 3);
        List<Asignatura> materiasEst = new LinkedList<>();
        Estudiante e = new Estudiante(2104481, "Daniel", "Cast", 6, 70, 001, 19213, 4, materiasEst);
        int pendiente = sc.calcularImpacto(e, a);
        int total = pa.getNumero_creditos();
        boolean c = pendiente<total;
        assertTrue(c);

        }    
    

    @Test
    public void pruebaDebeEstarViendolaActual()throws ExcepcionSolicitudes{
        SolicitudesCancelaciones sc = new SolicitudesCancelaciones();
        List<Asignatura> lista = new LinkedList();
        lista = sc.getVistasActualmente();
        ProgramaAcademico pa = new ProgramaAcademico(101,"Ingenieria Civil",30,18,150);
        List<Asignatura> materiasEst = new LinkedList<>();
        Estudiante e = new Estudiante(2104481, "Daniel", "Cast", 6, 70, 001, 19213, 4, materiasEst);
        Asignatura a=new Asignatura(3, "Fisica", pa, "Ciencia", 3, 3);
        sc.calcularImpacto(e, a);
        int res=0;
        for(Asignatura i:lista){
            if(i==a){
                res=1;
            }
        assertEquals(res,0);
        }
        

    }

    @Test
    public void registroJustificacion() throws ExcepcionSolicitudes{
         SolicitudesCancelaciones sc = new SolicitudesCancelaciones();
         List<Asignatura> materiasEst = new LinkedList<>();
         ProgramaAcademico pa = new ProgramaAcademico(101,"Ingenieria Civil",30,18,150);
         Asignatura a=new Asignatura(3, "Fisica", pa, "Ciencia", 3, 3);
         Estudiante e = new Estudiante(2104481, "Daniel", "Cast", 6, 70, 001, 19213, 4, materiasEst);
         String justificacion;
         justificacion= "Demasiada carga academica";
         try{
             //Que sea valido
            sc.solicitarCancelacion(e, a, justificacion);

         }catch(ExcepcionSolicitudes o){
            throw new ExcepcionSolicitudes(o.getMessage());
         } 
    }
}


