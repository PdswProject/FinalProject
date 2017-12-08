/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.services;


import static com.google.inject.Guice.createInjector;
import com.google.inject.Injector;
import edu.eci.pdsw.samples.dao.ConsejeroDAO;
import edu.eci.pdsw.samples.dao.ConsultaSolicitudCancelacionDAO;
import edu.eci.pdsw.samples.dao.DecanoDAO;
import edu.eci.pdsw.samples.dao.EstudianteDAO;
import edu.eci.pdsw.samples.dao.mybatis.ConsejeroDAOMyBatis;
import edu.eci.pdsw.samples.dao.mybatis.ConsultaSolicitudCancelacionDAOMyBatis;
import edu.eci.pdsw.samples.dao.mybatis.DecanoDAOMyBatis;
import edu.eci.pdsw.samples.dao.mybatis.EstudianteDAOMyBatis;
import edu.eci.pdsw.samples.services.impl.CalculadorDeImpactoSimple;
import edu.eci.pdsw.samples.services.impl.ServiciosCancelacionesImpl;
import edu.eci.pdsw.samples.services.impl.ExtractorJSON;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;


/**
 *
 * @author USER
 */
public class ServiciosCancelacionesFactory {
    private static  ServiciosCancelacionesFactory instance = new ServiciosCancelacionesFactory();

    private static Injector injector;
    private static Injector testInjector;

    public ServiciosCancelacionesFactory() {
        
        
         injector = createInjector(new XMLMyBatisModule() {

            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setClassPathResource("mybatis-config.xml");
                bind(ServiciosCancelaciones.class).to(ServiciosCancelacionesImpl.class);
                bind(EstudianteDAO.class).to(EstudianteDAOMyBatis.class);                
                bind(DecanoDAO.class).to(DecanoDAOMyBatis.class);
                bind(ConsejeroDAO.class).to(ConsejeroDAOMyBatis.class);
                System.out.println("VAMOS?");
                
                bind(ConsultaSolicitudCancelacionDAO.class).to(ConsultaSolicitudCancelacionDAOMyBatis.class);
                bind(CalculadorDeImpacto.class).to(CalculadorDeImpactoSimple.class);
                bind(ExtractorPlanEstudios.class).to(ExtractorJSON.class);
                
            }
        

        }
        );

        testInjector = createInjector(new XMLMyBatisModule() {

            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setClassPathResource("mybatis-config-h2.xml");
                bind(ServiciosCancelaciones.class).to(ServiciosCancelacionesImpl.class);
                bind(EstudianteDAO.class).to(EstudianteDAOMyBatis.class);                
                bind(DecanoDAO.class).to(DecanoDAOMyBatis.class);
                bind(ConsejeroDAO.class).to(ConsejeroDAOMyBatis.class);
                bind(ConsultaSolicitudCancelacionDAO.class).to(ConsultaSolicitudCancelacionDAOMyBatis.class);
                bind(CalculadorDeImpacto.class).to(CalculadorDeImpactoSimple.class);
                bind(ExtractorPlanEstudios.class).to(ExtractorJSON.class);
            }

        }
        );
        

    }

    public ServiciosCancelaciones getServiciosCancelaciones() {
                System.out.println("que devuelve!#$%&/(/&%$##$%&/");
        System.out.println("que devuelve?"+ injector.getInstance(ServiciosCancelacionesImpl.class));
        return injector.getInstance(ServiciosCancelacionesImpl.class);
    }
    
    public ServiciosCancelaciones getTestingServiciosCancelaciones() {
        return testInjector.getInstance(ServiciosCancelacionesImpl.class);
    }
    
    public static ServiciosCancelacionesFactory getInstance() {
        return instance;
    }

}

