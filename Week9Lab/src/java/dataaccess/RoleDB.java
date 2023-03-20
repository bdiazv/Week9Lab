package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import models.Role;
import models.User;

public class RoleDB {
    public List<Role> getAll() throws Exception {
       EntityManagerFactory emFactory = DBUtil.getEmFactory();
        
        EntityManager em;
        em = emFactory.createEntityManager();
        
        return em.createNamedQuery("Role.findAll", Role.class).getResultList();
    }
}