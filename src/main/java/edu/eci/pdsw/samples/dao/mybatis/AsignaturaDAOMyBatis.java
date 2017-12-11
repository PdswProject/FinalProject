/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.eci.pdsw.samples.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.pdsw.samples.dao.AsignaturaDAO;
import edu.eci.pdsw.samples.dao.PersistenceException;
import edu.eci.pdsw.samples.dao.mybatis.mappers.AsignaturaMapper;
import edu.eci.pdsw.samples.dao.mybatis.mappers.ConsultaSolicitudCancelacionMapper;
import edu.eci.pdsw.samples.entities.Asignatura;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author cesar
 */
public class AsignaturaDAOMyBatis  implements AsignaturaDAO {

    private List<Asignatura> listas;
    @Inject
    AsignaturaMapper mater;
    private SqlSession sqlss;
    private SqlSession session;
    private AsignaturaMapper equmapper;
    public AsignaturaDAOMyBatis(){
    
    }
    public AsignaturaDAOMyBatis(SqlSession session) {
        this.sqlss = session;
        equmapper = session.getMapper(AsignaturaMapper.class);
    }
    
    
    @Override
    public List<Asignatura> allByEstud(int codigo) {
        List<Asignatura> listo=mater.allByEstud(codigo);

        for(int i=0;i<listo.size();i++){
            Asignatura re=listo.get(i);

        }
        return listo;
    }

    @Override
    public List<Asignatura> allAsig() {
        listas=mater.allAsig();
        
        for(int i=0;i<listas.size();i++){
            Asignatura re=listas.get(i);
            System.out.println("que mateiras imprime"+re.getNombre());

        }
        return listas;
    }
    
}
