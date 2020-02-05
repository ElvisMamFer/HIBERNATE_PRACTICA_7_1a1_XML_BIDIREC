package com.educomser.entity.dao.impl;

import com.educomser.entity.Direccion;
import com.educomser.entity.dao.DireccionDao;
import com.educomser.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DireccionDaoImpl implements DireccionDao
{
    private Session session;
    private Transaction tx; 
    
    private void iniciarSession()
    {
        session=HibernateUtil.getSessionFactory().openSession(); //Llamanos a nuestra sesion y la abrimos
        tx=session.beginTransaction();
    } 
    
    @Override
    public void create(Direccion direccion) {           
        try 
        {
            iniciarSession();
            session.save(direccion);
            tx.commit();   
        }
        catch (HibernateException ex) //En caso de presentarse alguna excepcion
        {
            tx.rollback();
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, " | ERROR {0}", ex);
        }
        finally
        {
            session.close();                    
        }
    }

    @Override
    public void update(Direccion direccion) {
    try 
        {
            iniciarSession();
            session.update(direccion);
            tx.commit();   
        }
        catch (HibernateException ex) //En caso de presentarse alguna excepcion
        {
            tx.rollback();
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, " | ERROR {0}", ex);
        }
        finally
        {
            session.close();                    
        }
    }

    @Override
    public void delete(Direccion direccion) {
    try 
        {
            iniciarSession();
            session.delete(direccion);
            tx.commit();   
        }
        catch (HibernateException ex) //En caso de presentarse alguna excepcion
        {
            tx.rollback();
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, " | ERROR {0}", ex);
        }
        finally
        {
            session.close();                    
        }
    }

    @Override
    public Direccion findById(int id)
    {
        Direccion direccion=null;
        try
        {
            iniciarSession();
            direccion=(Direccion) session.get(Direccion.class, id); //Esto busca un obj direccion (select * from direccionwhere id=?)
            tx.commit();   
        }
              catch (HibernateException ex) //En caso de presentarse alguna excepcion
              {
                  tx.rollback();
                  Logger.getLogger(getClass().getName()).log(Level.SEVERE, " | ERROR {0}", ex);
              }
              finally
              {
                  session.close();                    
              } 
        
        return direccion;
    }

    @Override
    public List<Direccion> getAll() 
    {
        List<Direccion> list=new ArrayList<Direccion>();
    
        try
        {
            iniciarSession();
            list= session.createQuery("from Direccion").list(); //SQL           
            
            tx.commit();   
        }
        
        catch (HibernateException ex) //En caso de presentarse alguna excepcion
              {
                  tx.rollback();
                  Logger.getLogger(getClass().getName()).log(Level.SEVERE, " | ERROR {0}", ex);
              }
              finally
              {
                  session.close();                    
              } 
        
        return list;
    
    
    
    }
    
}
