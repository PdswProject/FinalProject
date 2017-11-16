/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.finalproject.services;

import static com.google.inject.Guice.createInjector;
import com.google.inject.Injector;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

/**
 *
 * @author USER
 */
public class ServicioCancelacionesFactory {
    private static ServicioCancelacionesFactory instance = new ServicioCancelacionesFactory();

    private static Injector injector;
    
    private static Injector testInjector;

    public ServicioCancelacionesFactory() {
        
         injector = createInjector(new XMLMyBatisModule() {

            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);              
                setClassPathResource("mybatis-config.xml");
                
            }

        }
        );

        testInjector = createInjector(new XMLMyBatisModule() {

            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setClassPathResource("mybatis-config-h2.xml");
                
            }

        }
        );

    }

    public Solicitudes getSolicitudes() {
        return injector.getInstance(Solicitudes.class);
    }

    public Solicitudes getTestingSolicitudes() {
        return testInjector.getInstance(Solicitudes.class);
    }
    
    public static ServicioCancelacionesFactory getInstance() {
        return instance;
    }

}

