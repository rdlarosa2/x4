package com.nisum.usuario.dao;

import com.nisum.usuario.entity.Phone;
import com.nisum.usuario.entity.User;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection

    @Autowired
    public UserDAOImpl(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }

    // implement save method
    @Override
    @Transactional
    public User save(User theUser) {
        entityManager.persist(theUser);
        return theUser;
    }

    @Override
    @Transactional
    public Phone savePhone(Phone thePhone) {
        entityManager.persist(thePhone);
        return thePhone;
    }


    @Override
    @Transactional
    public User getUserById(Integer id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    @Transactional
    public List<User> findAll() {
        return entityManager.createQuery("from User").getResultList();
    }

    public List<Phone> getPhonesByUserId(Integer userId) {
        return entityManager.createQuery("from Phone").getResultList();
    }
}
