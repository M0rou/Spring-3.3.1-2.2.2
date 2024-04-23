package web.dao;

import org.springframework.stereotype.Service;
import web.model.User;

@Service
public interface UserDao {
    void create(User user);
    User getUser(int i);
    User getUser(String name, String lastname);
    void update(int i, User user);
    void delete(int i);
}
