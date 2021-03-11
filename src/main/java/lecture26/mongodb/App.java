package lecture26.mongodb;

import com.mongodb.client.model.Filters;
import lecture26.mongodb.dao.UserDao;
import lecture26.mongodb.model.User;

import java.util.List;

public class App {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        List<User> developers = userDao.findAllByFilter(Filters.lt("age", 25));
        System.out.println(developers);
    }

    private static User createUser() {
        User user = new User();
        user.setAge(25);
        user.setFullName("Bill White");
        user.setTitle("Senior Java Developer");
        return user;
    }
}
