package lecture24.hibernate.dao;

import lecture24.hibernate.model.annotation.User;
import lecture24.hibernate.util.HibernateSessionAnnotationFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class UserDao {
    SessionFactory sessionFactory = HibernateSessionAnnotationFactoryUtil.getSessionFactory();

    public void createUser(User user) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }
    }

    public User findById(int id) {
        try (Session session = sessionFactory.openSession()) {
            User user = session.get(User.class, id);
            if (user != null) {
//                Hibernate.initialize(user.getAutos());
            }
            return user;
        }
    }

    public List<User> findUserByMinAge(int age) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query<User> query = session.createQuery("FROM User Where age <=:minAge ORDER BY age", User.class);
            query.setParameter("minAge", age);
            List<User> resultList = query.getResultList();
            session.getTransaction().commit();
            return resultList;
        }
    }

    public int getMaxAge() {
        try (Session session = sessionFactory.openSession()) {
            Query<Integer> query = session.createQuery("SELECT max(age) FROM User", Integer.class);
            return query.getResultList().get(0);
        }
    }

    public void increaseAge(int id) {
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            User user = session.get(User.class, id);
            Query query = session.createQuery("UPDATE User SET age =: newAge WHERE id =: id");
            query.setParameter("newAge", user.getAge() + 1);
            query.setParameter("id", id);
            query.executeUpdate();
            session.getTransaction().commit();
        }
    }

    public void delete(int id) {
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            Query query = session.createQuery("DELETE FROM User WHERE id =: id");
            query.setParameter("id", id);
            query.executeUpdate();
            session.getTransaction().commit();
        }
    }
}
