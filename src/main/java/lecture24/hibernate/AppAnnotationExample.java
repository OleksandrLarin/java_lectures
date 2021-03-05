package lecture24.hibernate;


import lecture24.hibernate.dao.UserDao;
import lecture24.hibernate.model.annotation.User;

import java.util.List;

public class AppAnnotationExample {
    public static void main(String[] args) {

//        createUsers();
//        Auto auto = new Auto();
//        auto.setModel("Mazda");
//        auto.setUser(user);
//
//        AutoDao autoDao = new AutoDao();
//        autoDao.createAuto(auto);

        UserDao userDao = new UserDao();

        userDao.delete(3);
        List<User> users = userDao.findUserByMinAge(25);
        userDao.increaseAge(2);

        Integer maxAge = userDao.getMaxAge();

        System.out.println(users);
        System.out.println("Max age is: " + maxAge);


    }

    private static void createUsers() {
        User bill = new User();
        bill.setAge(23);
        bill.setName("Bill");
        User john = new User();
        john.setAge(20);
        john.setName("John");
        User robert = new User();
        robert.setAge(29);
        robert.setName("Robert");

        UserDao userDao = new UserDao();

        userDao.createUser(bill);
        userDao.createUser(john);
        userDao.createUser(robert);
    }
}
