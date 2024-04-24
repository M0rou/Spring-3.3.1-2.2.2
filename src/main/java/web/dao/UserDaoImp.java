package web.dao;


import org.springframework.stereotype.Component;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

//@Repository
//public class UserDaoImp implements UserDao {
//    @Autowired
//    private EntityManager em;
//
//
////    @Override
////    public void create(User user) {
////        em.persist(user);
////    }
////
////    @Override
////    public User getUser(int i) {
//////        return em.getCurrentSession().get(User.class, i);
////    }
////
////    @Override
////    public User getUser(String name, String lastname) {
//////        Query query = em.getCurrentSession().createQuery("from User where name = :name and lastname = :lastname");
//////        query.setParameter("name", name);
//////        query.setParameter("lastname", lastname);
//////        return (User) query.getSingleResult();
////        return null;
////    }
////
////    @Override
////    public void update(int i, User user) {
//////        Query query = em.getCurrentSession().createQuery("update User u set " +
//////                "u.name = :name, " +
//////                "u.lastname = :lastname," +
//////                "u.email = :email, " +
//////                "u.username = :username where u.id = :id");
//////        query.setParameter("name", user.getName());
//////        query.setParameter("lastname", user.getLastname());
//////        query.setParameter("email", user.getEmail());
//////        query.setParameter("username", user.getUsername());
//////        query.setParameter("id", i);
//////        query.executeUpdate();
////    }
////
////    @Override
////    public void delete(int i) {
////        User user = em.find(User.class, i);
////        if (user != null) {
////            em.remove(user);
////        }
////    }
//
//}
@Component
public class UserDaoImp {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void create(User user) {
        entityManager.persist(user);
    }

    @Transactional
    public User getUser(int i) {
        return entityManager.find(User.class, i);
    }

    @Transactional
    public User getUser(String name, String lastname) {
        Query query = entityManager.createQuery("from User where name = :name and lastname = :lastname");
        query.setParameter("name", name);
        query.setParameter("lastname", lastname);
        return (User) query.getSingleResult();
    }

    @Transactional
    public List<User> getUsers() {
        Query query = entityManager.createQuery("from User");
        return (List<User>) query.getResultList();
    }

    @Transactional
    public void update(int id, User user) {
        Query query = entityManager.createQuery("update User set " +
                "name = :name, " +
                "lastname = :lastname, " +
                "email = :email, " +
                "password = :password " +
                "where id = :id");
        query.setParameter("name", user.getName());
        query.setParameter("lastname", user.getLastname());
        query.setParameter("email", user.getEmail());
        query.setParameter("password", user.getPassword());
        query.setParameter("id", id);
        query.executeUpdate();
    }
    @Transactional
    public void delete(int id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }
}