package edu.eci.pdsw.finalproject.test;

import edu.eci.pdsw.finalproject.entities.Asignatura;
import edu.eci.pdsw.finalproject.entities.PlanEstudios;
import edu.eci.pdsw.finalproject.entities.ProgramaAcademico;
import edu.eci.pdsw.finalproject.services.ExcepcionSolicitudes;
import edu.eci.pdsw.finalproject.services.impl.SolicitudesCancelacionMock;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import org.junit.Test;

public class SolicitudCancelacionTest {
    
    
    /**
     * CLASES DE EQUIVALENCIA PARA METODO CALCULO IMPACTO SIMPLE
     * 
     *         Clase1: Materia ingresada no se encuentra en el plan de estudios (no registrada)
     * 
     *         Resultado: Una excepcion
     * 
     *         Clase2: Creditos academicos pendientes por ver debe ser menor a creditos totales de programa academico
     * 
     *         Resultado: Un valor booleano True
     *         
     *         Clase3: La materia la este viendo el estudiante
     *  
     *         Resultado: True
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
     * 
     * 
     * 
     * @throws edu.eci.pdsw.finalproject.services.ExcepcionSolicitudes
     */
    
    
    @Test 
    public void pruebaMateriaNoRegistrada()throws ExcepcionSolicitudes{
        SolicitudesCancelacionMock sc = new SolicitudesCancelacionMock(); 
        ProgramaAcademico pa = new ProgramaAcademico(101,"Ingenieria Civil",30,18,150);
        Asignatura a= new Asignatura(1,"fisica",pa,"ciencias",2,3);
        sc.calculoImpactoSimple(a);
        Asignatura b= new Asignatura(2,"mate",pa,"ciencias",2,5);
        List<Asignatura> lista=new LinkedList();
        lista.add(a);
        PlanEstudios pe = new PlanEstudios(20,65,pa,lista);
        assertEquals(true, pe.getMaterias().equals(b));
    }
    
    @Test 
    public void creditosPendientesConsistentes() throws ExcepcionSolicitudes{
        SolicitudesCancelacionMock sc = new SolicitudesCancelacionMock();
        ProgramaAcademico pa = new ProgramaAcademico(101,"Ingenieria Civil",30,18,150);
        Asignatura a= new Asignatura(1,"fisica",pa,"ciencias",2,3);
        int creditos= sc.calculoImpactoSimple(a);
        }    
    
    //CLASES DE EQUIVALENCIA PARA METODO LOAD ASIGNATURAS ACTUALES
    @Test
    public void materiaPlanEstudios()throws ExcepcionSolicitudes{
        boolean res=false;
        List<Asignatura> ej1; 
        SolicitudesCancelacionMock sc = new SolicitudesCancelacionMock();
        ProgramaAcademico pa = new ProgramaAcademico(101,"Ingenieria Civil",30,18,150);
        Asignatura asig=new Asignatura(111,"FIEM", pa, "Cualquiera", 12345, 12);
        try{
        ej1=sc.loadAsignaturasActuales();
      
        for (int i=0 ; i< ej1.size();i++){
            Asignatura tem=ej1.get(i);
            if(tem.getNombre().equals(asig.getNombre())){
                res=true;
            }
            else{
                res=false;
            }
        }
        assertTrue(res);            
           
        }catch(ExcepcionSolicitudes e){
                assertEquals(e.getMessage(), "Materia mostrada no esta en el plan de estudios o no la esta viendo");
            }
    }
    
    @Test
    public void registrojustificacion() throws ExcepcionSolicitudes{
         SolicitudesCancelacionMock sc = new SolicitudesCancelacionMock();
         sc.registroJustificacion();
         //COmento que en la justificacion debe asegurarse que quedo almacenada
         //o si no arroje un error.
    
    }
    
}


