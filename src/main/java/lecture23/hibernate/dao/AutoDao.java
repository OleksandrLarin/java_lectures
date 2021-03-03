package lecture23.hibernate.dao;

import lecture23.hibernate.model.annotation.Auto;
import lecture23.hibernate.util.HibernateSessionAnnotationFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AutoDao {
    SessionFactory sessionFactory = HibernateSessionAnnotationFactoryUtil.getSessionFactory();

    public void createAuto(Auto auto) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            if (auto.getUser() != null){
                session.save(auto.getUser());
            }
            session.save(auto);
            session.getTransaction().commit();
        }
    }
}
