package lecture30.module.dao;

import lecture30.module.model.User;

import java.util.List;

public interface FollowersDao {
    List<User> findAllFollowers(User author);

}
