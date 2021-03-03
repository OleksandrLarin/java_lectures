package lecture23.hibernate.dao;

import lecture23.hibernate.model.annotation.User;
import lecture23.hibernate.util.HibernateSessionAnnotationFactoryUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
        try (Session session = sessionFactory.openSession()){
            User user = session.get(User.class, id);
            if (user != null) {
                Hibernate.initialize(user.getAutos());
            }
            return user;
        }
    }
}
