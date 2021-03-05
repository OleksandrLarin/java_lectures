package lecture25.jpa;

import lecture25.jpa.model.entities.Account;
import lecture25.jpa.model.entities.CarRent;
import lecture25.jpa.model.entities.CarRenter;
import lecture25.jpa.util.EntityManagerFactoryUtil;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

public class App {
    public static void main(String[] args) {
        EntityManager entityManager = EntityManagerFactoryUtil.getEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        TypedQuery<CarRenter> users =  entityManager.createQuery("FROM CarRenter Where account.accountAmount < 50", CarRenter.class);

//        System.out.println(resultList);

        CarRenter renter = new CarRenter();
        renter.setFullName("Joseph Stephan");
        renter.setDriverLicenceId("B696584");
        Account account = new Account();
        account.setAccountAmount(BigDecimal.valueOf(256));
        renter.setAccount(account);

        entityManager.persist(renter);

        //Update
        Account account1 = entityManager.find(Account.class, 262);
        BigDecimal newAmount = account1.getAccountAmount().subtract(BigDecimal.valueOf(12));
        account1.setAccountAmount(newAmount);
        entityManager.merge(account1);

        Query query = entityManager.createQuery("DELETE FROM CarRenter WHERE driverLicenceId =: id");
        query.executeUpdate();

        TypedQuery<CarRent> carRentTypedQuery = entityManager.createQuery("FROM CarRent", CarRent.class);
        List<CarRent> resultList = carRentTypedQuery.getResultList();

        //принудительно сохраняет все сущности в базу
        entityManager.flush();

        Session session = entityManager.unwrap(Session.class);

        transaction.commit();
    }

}
