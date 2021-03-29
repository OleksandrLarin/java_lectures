package lecture30.module.dao;

import lecture30.module.model.User;

import java.util.List;

public interface AuthorDao {
    List<User> findAllAuthors();

    List<User> findTopAuthors(int limit);
}
