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
    public void pruebaMateriaNoRegistrada()throws ExcepcionSolicitudes{
        SolicitudesCancelaciones sc = new SolicitudesCancelaciones(); 
        sc.cargarDatosPrueba();
        ProgramaAcademico cer;
        List<Asignatura> lista = new LinkedList();
        lista = sc.getAsignaturasPlanEstudios();
        cer = new ProgramaAcademico(101,"Ingenieria Civil",30,18,150);
        Asignatura a=new Asignatura(3, "Fisica", cer, "Ciencia", 3, 3);
        sc.calculoImpactoSimple(a);
        int res=0;
        for(Asignatura b:lista){
            if(b==a){
                res=1;
            }
        assertEquals(res,0);
        }
       
    }
    
    @Test 
    public void pruebaCreditosPendientesConsistentes() throws ExcepcionSolicitudes{
        SolicitudesCancelaciones sc = new SolicitudesCancelaciones();
        ProgramaAcademico pa = new ProgramaAcademico(101,"Ingenieria Civil",30,18,150);
        Asignatura a=new Asignatura(3, "Fisica", pa, "Ciencia", 3, 3);
        int pendiente = sc.calculoImpactoSimple(a);
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
        Asignatura a=new Asignatura(3, "Fisica", pa, "Ciencia", 3, 3);
        sc.calculoImpactoSimple(a);
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
         try{
             //Que sea valido
            String tem=sc.registroJustificacion();
            Assert.assertFalse(tem=="");

         }catch(ExcepcionSolicitudes e){
            throw new ExcepcionSolicitudes(e.getMessage());
         }
         
   }
    
    @Test
    public void almacenamientoJustificacion()throws ExcepcionSolicitudes{
        
         SolicitudesCancelaciones sc = new SolicitudesCancelaciones();
         try{
            String re=sc.registroJustificacion();
            Assert.assertFalse(re=="");         
         }catch(ExcepcionSolicitudes e){
             throw new ExcepcionSolicitudes(e.getMessage());
         }
            
         //COmento que en la justificacion debe asegurarse que quedo almacenada
         //o si no arroje un error.    
    
    }
}


