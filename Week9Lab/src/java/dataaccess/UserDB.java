package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import models.*;


public class UserDB {

    public List<User> getAll() throws Exception {
        EntityManagerFactory emFactory = DBUtil.getEmFactory();
        
        EntityManager em;
        em = emFactory.createEntityManager();
        
        return em.createNamedQuery("User.findAll", User.class).getResultList();
    }
    
    public User get(String email) throws Exception {
        EntityManagerFactory emFactory = DBUtil.getEmFactory();
        
        EntityManager em = emFactory.createEntityManager();
        
        try{
            User user = em.find(User.class, email);
            return user;
        } finally {
            em.close();
        }
    }
    
    public void insert(User user) throws Exception{
        EntityManagerFactory emFactory = DBUtil.getEmFactory();
        
        EntityManager em = emFactory.createEntityManager();   
        
        EntityTransaction trans = em.getTransaction();
        
        try{
            trans.begin();
            em.persist(user);
            trans.commit();
        }catch (Exception ex) {
            trans.rollback();
        }finally{
            em.close();
        }
    }

    public void update(User user) throws Exception{
        EntityManagerFactory emFactory = DBUtil.getEmFactory();
        
        EntityManager em = emFactory.createEntityManager();   
        
        EntityTransaction trans = em.getTransaction();
        
        try{
            trans.begin();
            em.merge(user);
            trans.commit();
        }catch (Exception ex) {
            trans.rollback();
        }finally{
            em.close();

        }
}
    public void delete(User user) throws Exception{
        EntityManagerFactory emFactory = DBUtil.getEmFactory();
        
        EntityManager em = emFactory.createEntityManager();   
        
        EntityTransaction trans = em.getTransaction();
        
        try{
            trans.begin();
            em.remove(user);
            trans.commit();
        }catch (Exception ex) {
            trans.rollback();
        }finally{
            em.close();        
    }
}

    public void insert(String email, boolean activity, String first_name, String last_name, String password, Role role) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}        
        
        
        