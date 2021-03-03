package lecture23.hibernate;


import lecture23.hibernate.dao.UserDao;
import lecture23.hibernate.model.annotation.User;

public class AppAnnotationExample {
    public static void main(String[] args) {
//        User user = new User();
//        user.setAge(23);
//        user.setName("Bill");
//
//        Auto auto = new Auto();
//        auto.setModel("Mazda");
//        auto.setUser(user);
//
//        AutoDao autoDao = new AutoDao();
//        autoDao.createAuto(auto);
        UserDao userDao = new UserDao();
        User user = userDao.findById(3);

        System.out.println(user);
    }
}
