package DAO;

import Interfaces.UserDao;
import Models.User;
import Utils.SessionFactoryUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    public UserDaoImpl(){
        sessionFactory = SessionFactoryUtil.getSessionFactory();
    }

    public User findById(int id) {
        Session session = sessionFactory.openSession();
        return session.get(User.class,id);
    }

    public void save(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }

    public void delete(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
    }

    public void update(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
    }

    public User findByNameAndPassword(String name, String password) throws NoResultException {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<User> criteria = cb.createQuery(User.class);
        Root<User> root = criteria.from(User.class);
        criteria.select(root).where(cb.like(root.get("name"),name),cb.like(root.get("password"),password));
        return session.createQuery(criteria).getSingleResult();
    }

    public User findByName(String name) throws NoResultException {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<User> criteria = cb.createQuery(User.class);
        Root<User> root = criteria.from(User.class);
        criteria.select(root).where(cb.like(root.get("name"),name));
        return session.createQuery(criteria).getSingleResult();
    }
}
