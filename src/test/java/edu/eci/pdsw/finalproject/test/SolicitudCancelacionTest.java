package edu.eci.pdsw.finalproject.test;

import edu.eci.pdsw.finalproject.entities.Asignatura;
import edu.eci.pdsw.finalproject.entities.Estudiante;
import edu.eci.pdsw.finalproject.entities.PlanEstudios;
import edu.eci.pdsw.finalproject.entities.ProgramaAcademico;
import edu.eci.pdsw.finalproject.services.ExcepcionSolicitudes;
import edu.eci.pdsw.finalproject.services.impl.ServiciosCancelacionesImpl;
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
//<<<<<<< HEAD
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
        
        ServiciosCancelacionesImpl sc = new ServiciosCancelacionesImpl(); 
        
        Asignatura c=new Asignatura(5, "Quimica", cer, "Ciencia", 3, 3);
        sc.calcularImpacto(e, c);
        int res=0;
        for(Asignatura i:materiasPlan){
            if(i==c){}
        }
        }
//=======
    public void pruebaMateriaNoRegistrada()throws ExcepcionSolicitudes{
        List<Asignatura> materiasEst = new LinkedList<>();
        Estudiante e = new Estudiante(2104481, "Daniel", "Cast", 6, 70, 001, 19213, 4, materiasEst);
    
        ServiciosCancelacionesImpl sc = new ServiciosCancelacionesImpl(); 
        sc.cargarDatosPrueba();
        ProgramaAcademico cer;
        List<Asignatura> lista = new LinkedList();
        lista = sc.getAsignaturasPlanEstudios();
        cer = new ProgramaAcademico(101,"Ingenieria Civil",30,18,150);
        Asignatura a=new Asignatura(3, "Fisica", cer, "Ciencia", 3, 3);
        int req=sc.calcularImpacto(e,a);
        int res=0;
        for(Asignatura b:lista){
            if(b==a){
//>>>>>>> cambie algunos nombres
                res=1;
            }
        System.out.println(res);
        assertEquals(res,0);
        }
    
    }
    
    @Test 
    public void pruebaCreditosPendientesConsistentes() throws ExcepcionSolicitudes{
        ServiciosCancelacionesImpl sc = new ServiciosCancelacionesImpl();
        ProgramaAcademico pa = new ProgramaAcademico(101,"Ingenieria Civil",30,18,150);
//<<<<<<< HEAD
        Asignatura a=new Asignatura(3, "Fisica", pa, "Ciencia", 3, 3);
        List<Asignatura> materiasEst = new LinkedList<>();
        Estudiante e = new Estudiante(2104481, "Daniel", "Cast", 6, 70, 001, 19213, 4, materiasEst);
        int pendiente = sc.calcularImpacto(e, a);
//=======
        Asignatura af=new Asignatura(3, "Fisica", pa, "Ciencia", 3, 3);
        int pendienter = sc.calcularImpacto(e,af);
//>>>>>>> cambie algunos nombres
        int total = pa.getNumero_creditos();
        boolean c = pendiente<total;
        assertTrue(c);

        }    
    

    @Test
    public void pruebaDebeEstarViendolaActual()throws ExcepcionSolicitudes{
//<<<<<<< HEAD
        ServiciosCancelacionesImpl sc = new ServiciosCancelacionesImpl();
        List<Asignatura> lista = new LinkedList();
        lista = sc.getVistasActualmente();
        ProgramaAcademico pa = new ProgramaAcademico(101,"Ingenieria Civil",30,18,150);
        List<Asignatura> materiasEst = new LinkedList<>();
        Estudiante e = new Estudiante(2104481, "Daniel", "Cast", 6, 70, 001, 19213, 4, materiasEst);
        Asignatura a=new Asignatura(3, "Fisica", pa, "Ciencia", 3, 3);
        //sc.calcularImpacto(e, a);
//=======

        lista = sc.getVistasActualmente();
        sc.calcularImpacto(e,null);
//>>>>>>> cambie algunos nombres
        int res=0;
        for(Asignatura i:lista){
            if(i==a){
                res=1;
            }
        assertEquals(res,1);
        }
        

    }

    @Test
    public void registroJustificacion() throws ExcepcionSolicitudes{
         ServiciosCancelacionesImpl sc = new ServiciosCancelacionesImpl();

         List<Asignatura> materiasEst = new LinkedList<>();
         ProgramaAcademico pa = new ProgramaAcademico(101,"Ingenieria Civil",30,18,150);
         PlanEstudios estud= new PlanEstudios(99, 20, pa, materiasEst);
         Asignatura a=new Asignatura(3, "Fisica", pa, "Ciencia", 3, 3);
         Estudiante e = new Estudiante(2104481, "Daniel", "Cast", 6, 70, 001, 19213, 4, materiasEst);
         String justificacion;
         justificacion= "Demasiada carga academica";
         try{
             //Que sea valido
            sc.solicitarCancelacion(e, a, justificacion,estud);

         }catch(ExcepcionSolicitudes o){
            throw new ExcepcionSolicitudes(o.getMessage());
         } 
    }
}


