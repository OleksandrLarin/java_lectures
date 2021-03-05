package lecture24.hibernate.dao;

import lecture24.hibernate.model.xml.Product;
import lecture24.hibernate.util.HibernateSessionXmlFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ProductDao {
    private SessionFactory sessionFactory = HibernateSessionXmlFactoryUtil.getSessionFactory();

    public void createProduct(Product product) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
        }
    }
}
