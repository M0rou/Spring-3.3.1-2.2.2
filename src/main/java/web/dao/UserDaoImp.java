package web.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private EntityManager em;

    @Override
    public void create(User user) {
        em.persist(user);
    }

    @Override
    public User getUser(int i) {
        return em.find(User.class, i);
    }

    @Override
    public User getUser(String name, String lastname) {
        Query query = em.createQuery("from User where name = :name and lastname = :lastname");
        query.setParameter("name", name);
        query.setParameter("lastname", lastname);
        return (User) query.getSingleResult();
    }

    @Override
    public void update(int i, User user) {
        Query query = em.createQuery("update User u set " +
                "u.name = :name, " +
                "u.lastname = :lastname," +
                "u.email = :email, " +
                "u.username = :username where u.id = :id");
        query.setParameter("name", user.getName());
        query.setParameter("lastname", user.getLastname());
        query.setParameter("email", user.getEmail());
        query.setParameter("username", user.getUsername());
        query.setParameter("id", i);
        query.executeUpdate();
    }

    @Override
    public void delete(int i) {
        em.remove(getUser(i));
    }
}
