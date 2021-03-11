package lecture26.mongodb.dao;

import lecture26.mongodb.model.User;
import org.bson.types.ObjectId;

import java.util.List;

public interface Dao<T> {
    T get(ObjectId id);

    List<T> findAll();

    void delete(ObjectId id);

    void save(User user);
}
