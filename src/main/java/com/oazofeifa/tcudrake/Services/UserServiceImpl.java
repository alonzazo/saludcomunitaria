package com.oazofeifa.tcudrake.Services;

import com.oazofeifa.tcudrake.Persistence.DAOs.UserDAO;
import com.oazofeifa.tcudrake.Persistence.Entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    private SessionFactory sessionFactory;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<User>();
        userDAO.findAll().iterator()
                .forEachRemaining(users::add);
        return users;
    }

    @Override
    public User findById(String id) {
        return userDAO.findById(id).get();
    }

    @Override
    public void delete(String id) {
        userDAO.deleteById(id);
    }

    @Override
    public User save(User user) {
        return userDAO.save(user);
    }

    public User create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userDAO.save(user);
    }

    public String findNamebyId(String id) throws Exception{
        //Abrimos una sesión a la base de datos
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("SELECT User.name FROM User WHERE email = :id");
        query.setParameter("id",id);
        String result = query.getSingleResult().toString();
        //Cerramos la sesión
        session.close();

        return result;
    }
}
