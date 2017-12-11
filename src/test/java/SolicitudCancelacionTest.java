import edu.eci.pdsw.samples.entities.Asignatura;
import edu.eci.pdsw.samples.entities.Estudiante;
import edu.eci.pdsw.samples.entities.PlanEstudios;
import edu.eci.pdsw.samples.entities.ProgramaAcademico;
import edu.eci.pdsw.samples.services.ServiciosCancelaciones;
import edu.eci.pdsw.samples.services.ServiciosCancelacionesFactory;
import edu.eci.pdsw.samples.services.ExcepcionSolicitudes;
import edu.eci.pdsw.samples.services.impl.ServiciosCancelacionesImpl;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import org.junit.Test;

public class SolicitudCancelacionTest {
    
    
    /**CALCULO IMPACTO SIMPLE

        Clases de equivalencia

        Clase1: materia no existe | materia no se está cursando | estudiante no existe.
        Resultado: error

        Clase2: materia existe, estudiante existe y materia se está cursando
        Resultado: la suma de los créditos de todas las materias que son correquisitos de la materia seleccionada

        Condiciones de frontera

        CF1: materia no existe | materia no se está cursando | estudiante no existe.
        Clases relacionadas: CE1,CE2
        Resultado esperado: Error

        CF2: la materia existe, pero los correquisitos registrados no existen
        Clases relacionadas : CE1,CE2
        Resultado esperado: Error

        CF3: la materia no tiene correquisitos
        Clases relacionadas: CE1,CE2
        Resultado esperado: los créditos de la materia seleccionada

        CF4: la materia(m1) tiene 2 correquisitos(m2 y m3)
        Clases relacionadas: CE1,CE2
        Resultado esperado: créditos m1 + creditos m2 + creditos m3

        CF5: los correquisitos(m2) de la materia tienen correquisitos
        Clases relacionadas: CE1,CE2
        Resultado esperado: creditos m1 + creditos m2 +impacto m2
      
      
      * EXTRAER PLAN ESTUDIOS
      *  Clases de equivalencia:
      * 
      *  Clase1: estudiante no existe | hay error en persistencia
      *  resultado esperado: Error
      * 
      *  Clase2: estudiante existe y no hay error en persistencia
      *  resultado esperado: retorna el plan de estudios de acuerdo al archivo JSON que lo representa.
      * 
      *  Condiciones de frontera:
      * 
      *  CF1: el estudiante no existe
      *  Clases relacionadas: C1
      *  resultado esperado: Error -estudiante no existe
      * 
      *  CF2: el estudiante existe y hay error en persistencia
      *  Clases relacionadas: C1,C2
      *  resultado esperado: Error en persistencia
      * 
      *  CF3: el estudiante existe y no hay error en persistencia
      *  Clases relacionadas: C2
      *  resultado esperado: retorna el plan de estudios de acuerdo al archivo JSON que lo representa.
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
     * @throws edu.eci.pdsw.finalproject.services.ExcepcionSolicitudes exception
     */
    

    //@Test
    public void pruebasCalculoImpactoSimpleClase1()
    {

        ServiciosCancelaciones  sc=ServiciosCancelacionesFactory.getInstance().getTestingServiciosCancelaciones();
        //ServiciosCancelaciones  sc=ServiciosCancelacionesFactory.getInstance().getServiciosCancelaciones();

        //ServiciosCancelaciones  sc=ServiciosCancelacionesFactory.getInstance().getTestingServiciosCancelaciones();
        //ServiciosCancelaciones  sc=ServiciosCancelacionesFactory.getInstance().getServiciosCancelaciones();
        ProgramaAcademico p = new ProgramaAcademico(1,"PlanPrueba",30,18,150);
        try {
            sc.calcularImpacto(null, null);
            
        } catch (ExcepcionSolicitudes e) {
            assertTrue("No se esta lanzando la excepcion adecuada",e.getMessage().equals("El estudiante no puede ser nulo"));
        }
    }
    
    
    //@Test
    public void pruebasExtraerPlanEstudiosClase2()
    {
        ServiciosCancelaciones  sc=ServiciosCancelacionesFactory.getInstance().getTestingServiciosCancelaciones();
        ProgramaAcademico p = new ProgramaAcademico(1,"PlanPrueba",30,18,150);
        
         Asignatura a1 =new Asignatura(1, "materia1",p, "pajarito", 1, 4);
        Asignatura a4 =new Asignatura(4, "materia4",p, "pajarito", 1, 3);
        Asignatura a5 =new Asignatura(5, "materia5", p, "pajarito", 1, 3);
        Asignatura a3 =new Asignatura(3, "materia3",p, "pajarito", 1, 4,Arrays.asList(a5));
        Asignatura a2 =new Asignatura(2, "materia2",p, "pajarito", 1, 2,Arrays.asList(a3,a4));
        Estudiante e = new Estudiante(1, "daniel", "asdf", 1, p, 1, 0, 0, 1, 1,Arrays.asList(a1,a2));
        PlanEstudios pe=new PlanEstudios(1, 5, new ProgramaAcademico(),Arrays.asList(a1,a4,a5,a3,a2));
        try {
            PlanEstudios plan = sc.extraerPlanEstudios(e);
            
            assertEquals("El plan extraido tiene mas o menos materias de las que deberia",pe.getNumero_materias(),plan.getNumero_materias());
            for(int i=0;i<pe.getNumero_materias();i++)
            {
                assertEquals("El plan extraido no tiene las materias que deberia",pe.getMaterias().get(i).getCodigo()
                                                                                 ,plan.getMaterias().get(i).getCodigo());
                assertEquals("Las materias no se estan creando con el numero de creditos adecuado",pe.getMaterias().get(i).getCreditos()
                                                                                                  ,plan.getMaterias().get(i).getCreditos());
            }
            
        } catch (ExcepcionSolicitudes ex) {
            Logger.getLogger(SolicitudCancelacionTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    //@Test
    public void pruebasExtraerPlanEstudiosClase1()
    {
        ServiciosCancelaciones  sc=ServiciosCancelacionesFactory.getInstance().getTestingServiciosCancelaciones();
        //ServiciosCancelaciones  sc=ServiciosCancelacionesFactory.getInstance().getServiciosCancelaciones();
        ProgramaAcademico p = new ProgramaAcademico(1,"PlanPrueba",30,18,150);
        try {
            sc.extraerPlanEstudios(null);
            
        } catch (ExcepcionSolicitudes e) {
            assertTrue("No se esta lanzando la excepcion adecuada",e.getMessage().equals("El estudiante no puede ser nulo"));
        }
        
    }
    
    //@Test
    public void pruebasExtraerPlanEstudiosClase20()
    {
        ServiciosCancelaciones  sc=ServiciosCancelacionesFactory.getInstance().getTestingServiciosCancelaciones();
        //ServiciosCancelaciones  sc=ServiciosCancelacionesFactory.getInstance().getServiciosCancelaciones();
        ProgramaAcademico p = new ProgramaAcademico(1,"PlanPrueba",30,18,150);
        
        Asignatura a1 =new Asignatura(1, "materia1",p, "pajarito", 1, 4);
        Asignatura a4 =new Asignatura(4, "materia4",p, "pajarito", 1, 3);
        Asignatura a5 =new Asignatura(5, "materia5", p, "pajarito", 1, 3);
        Asignatura a3 =new Asignatura(3, "materia3",p, "pajarito", 1, 4,Arrays.asList(a5));
        Asignatura a2 =new Asignatura(2, "materia2",p, "pajarito", 1, 2,Arrays.asList(a3,a4));
        
        Asignatura[] materiasEst = new Asignatura[2];
        List<Asignatura> pr=new ArrayList<Asignatura>();
        pr.add(a1);
        pr.add(a2);
        pr.add(a3);   
        pr.add(a4);
        pr.add(a5);
        for (int i=0;i<materiasEst.length;i++){
            materiasEst[i] = pr.get(i);
        } 
        
        Estudiante e = new Estudiante(1, "daniel", "asdf", 1, p, 1, 0, 0, 1, 1,pr);
        //PlanEstudios pe=new PlanEstudios(1, 5, new ProgramaAcademico(),materiasEst);
        PlanEstudios pe=new PlanEstudios(1, 5, new ProgramaAcademico(),pr);
        try {
            PlanEstudios plan = sc.extraerPlanEstudios(e);
            
            assertEquals("El plan extraido tiene mas o menos materias de las que deberia",pe.getNumero_materias(),plan.getNumero_materias());
            for(int i=0;i<pe.getNumero_materias();i++)
            {
               // assertEquals("El plan extraido no tiene las materias que deberia",pe.getMaterias().get(i).getCodigo()
                                                                                 //,plan.getMaterias().get(i).getCodigo());
                //assertEquals("Las materias no se estan creando con el numero de creditos adecuado",pe.getMaterias().get(i).getCreditos()
                                                                                   //               ,plan.getMaterias().get(i).getCreditos());
            }
            
        } catch (ExcepcionSolicitudes ex) {
            Logger.getLogger(SolicitudCancelacionTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Test 
    public void MateriaNoEstaRegistradaEnElPlanDeEstudios()throws ExcepcionSolicitudes{ /*
        
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
        }*/
        }

    public void pruebaMateriaNoRegistrada()throws ExcepcionSolicitudes{
        ProgramaAcademico pa = new ProgramaAcademico(101,"Ingenieria Civil",30,18,150);
        Asignatura as1=new Asignatura(10001,"Fisica1",pa,"Ciencias Basicas",1234,4);
        Asignatura as2=new Asignatura(10002,"Fisica2",pa,"Ciencias Basicas",1235,4);
        Asignatura as3=new Asignatura(10003,"Fisica3",pa,"Ciencias Basicas",1236,4);//fill(materiasEst, 0,1, as1);
        Asignatura[] materiasEst = new Asignatura[2];
        List<Asignatura> pr=new ArrayList<Asignatura>();
        pr.add(as1);
        pr.add(as2);
        pr.add(as3);   
        for (int i=0;i<pr.size();i++){
            materiasEst[i] = pr.get(i);
        } 
        ServiciosCancelacionesImpl sc = new ServiciosCancelacionesImpl(); 
        //sc.cargarDatosPrueba();
        ProgramaAcademico cer;
        //Asignatura[] lista = new Asignatura[10];
        List<Asignatura> lista=new ArrayList<Asignatura>();
        
        lista = sc.getAsignaturasPlanEstudios();
        cer = new ProgramaAcademico(101,"Ingenieria Civil",30,18,150);
        Asignatura a=new Asignatura(3, "Fisica", cer, "Ciencia", 3, 3);
        Estudiante e = new Estudiante(2104481, "Daniel", "Cast", 6,cer,1, 70, 001, 19213, 4, pr);
    
        //int req=sc.calcularImpacto(e,a);
        int res=0;
        for(Asignatura b:lista){
            if(b==a){

                res=1;
            }
        System.out.println(res);
        assertEquals(res,0);
        }
    
    }
    
    @Test 
    public void pruebaCreditosPendientesConsistentes() throws ExcepcionSolicitudes{
        /*
        ServiciosCancelacionesImpl sc = new ServiciosCancelacionesImpl();
        ProgramaAcademico pa = new ProgramaAcademico(101,"Ingenieria Civil",30,18,150);
        Asignatura a=new Asignatura(3, "Fisica", pa, "Ciencia", 3, 3);
        List<Asignatura> materiasEst = new LinkedList<>();
        Estudiante e = new Estudiante(2104481, "Daniel", "Cast", 6, 70, 001, 19213, 4, materiasEst);
        int pendiente = sc.calcularImpacto(e, a);
        Asignatura af=new Asignatura(3, "Fisica", pa, "Ciencia", 3, 3);
        int pendienter = sc.calcularImpacto(e,af);
        int total = pa.getNumero_creditos();
        boolean c = pendiente<total;
        assertTrue(c);*/

        }    
    

    @Test
    public void pruebaDebeEstarViendolaActual()throws ExcepcionSolicitudes{
        /*
        ServiciosCancelacionesImpl sc = new ServiciosCancelacionesImpl();
        List<Asignatura> lista = new LinkedList();
        lista = sc.getVistasActualmente();
        ProgramaAcademico pa = new ProgramaAcademico(101,"Ingenieria Civil",30,18,150);
        List<Asignatura> materiasEst = new LinkedList<>();
        Estudiante e = new Estudiante(2104481, "Daniel", "Cast", 6, 70, 001, 19213, 4, materiasEst);
        Asignatura a=new Asignatura(3, "Fisica", pa, "Ciencia", 3, 3);
        //sc.calcularImpacto(e, a);
        lista = sc.getVistasActualmente();
        sc.calcularImpacto(e,null);
        int res=0;
        for(Asignatura i:lista){
            if(i==a){
                res=1;
            }
        assertEquals(res,1);
        }
        */

    }

    @Test
    @SuppressWarnings("empty-statement")
    public void registroJustificacion() throws ExcepcionSolicitudes{
        
        try{
            ServiciosCancelacionesImpl sc = new ServiciosCancelacionesImpl();

            //List<Asignatura> materiasEst = new LinkedList<>();
            //int codigo, String nombre, ProgramaAcademico programa, String unidadAcademica, int profesor, int creditos
 
            ProgramaAcademico pa = new ProgramaAcademico(101,"Ingenieria Civil",30,18,150);
            
            Asignatura as1=new Asignatura(10001,"Fisica1",pa,"Ciencias Basicas",1234,4);
            Asignatura as2=new Asignatura(10002,"Fisica2",pa,"Ciencias Basicas",1235,4);
            Asignatura as3=new Asignatura(10003,"Fisica3",pa,"Ciencias Basicas",1236,4);//fill(materiasEst, 0,1, as1);
            Asignatura[] materiasEst = new Asignatura[2];
            List<Asignatura> pr=new ArrayList<Asignatura>();
            pr.add(as1);
            pr.add(as2);
            pr.add(as3);   
            for (int i=0;i<materiasEst.length;i++){
                materiasEst[i] = pr.get(i);
            }            
            //materiasEst.fill();
            //PlanEstudios estud= new PlanEstudios(99, 20, pa, materiasEst);
            PlanEstudios estud= new PlanEstudios(99, 20, pa, pr);
            Asignatura a=new Asignatura(3, "Fisica", pa, "Ciencia", 3, 3);
            Estudiante e = new Estudiante(2104481, "Daniel", "Cast", 6,pa,1, 70, 001, 19213, 4, pr);
            String justificacion;
            justificacion= "Demasiada carga academica";

            //Que sea valido
            sc.solicitarCancelacion(e, a, justificacion,estud);

            }catch(ExcepcionSolicitudes o){
                throw new ExcepcionSolicitudes(o.getMessage());
         } 
    }
}