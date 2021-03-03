package lecture23.hibernate.dao;

import lecture23.hibernate.model.xml.Category;
import lecture23.hibernate.util.HibernateSessionXmlFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CategoryDao {
    private SessionFactory sessionFactory = HibernateSessionXmlFactoryUtil.getSessionFactory();

    public void createCategory(Category category) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(category);
            session.getTransaction().commit();
        }
    }
}
