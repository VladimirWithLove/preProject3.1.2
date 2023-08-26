package com.example.PP_3_1_2.dao;

import com.example.PP_3_1_2.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> getAllUsers() {
        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    public User getUser(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUser(long id) {
        Query query = entityManager.createQuery("delete from User where id = :userid");
        query.setParameter("userid", id);
        query.executeUpdate();
    }

    @Override
    public void updateUser(long id, User user) {
        Query query = entityManager.createQuery("update User set name= :newName, surname= :newSurname, " +
                "age= :newAge, profession= :newProfession where id= :userId");
        query.setParameter("newName", user.getName());
        query.setParameter("newSurname", user.getSurname());
        query.setParameter("newAge", user.getAge());
        query.setParameter("newProfession", user.getProfession());
        query.setParameter("userId", id);

        query.executeUpdate();
    }
}
