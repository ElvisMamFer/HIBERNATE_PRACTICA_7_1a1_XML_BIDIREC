
package com.educomser.test;

import com.educomser.entity.Direccion;
import com.educomser.entity.Persona;
import com.educomser.entity.dao.DireccionDao;
import com.educomser.entity.dao.PersonaDao;
import com.educomser.entity.dao.impl.DireccionDaoImpl;
import com.educomser.entity.dao.impl.PersonaDaoImpl;
import com.educomser.util.HibernateUtil;
import java.util.Date;


public class DireccionAdicionar {

 
    public static void main(String[] args) {
       int  id=3;

        Persona p=new Persona();
        p.setId(id);
        p.setNombre("Pepe");
        p.setSueldo(5000);
        p.setContrato(true);
        p.setFechaNacimiento(new Date());
        
        Direccion dir =new Direccion();
        dir.setId(id);
        dir.setCalle("Avenida Buenos aereos");
        dir.setZona("San Pedro");
        dir.setNumero(1111111);
        //Setear la direccion en la persona
        dir.setPersona(p);
        //Creamos el Dao 
        DireccionDao dirDao= new DireccionDaoImpl();
        p.setDireccion(dir);
        
       //Creamos el Dao
        PersonaDao perDao=new PersonaDaoImpl();
        perDao.create(p);
        
        //Esta funcion solo usamos en aplicaciones de escritorio
        HibernateUtil.closeSessionFactory();

    }
    
}
