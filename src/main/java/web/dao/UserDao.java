package web.dao;

import web.model.User;

public interface UserDao {
    void create(User user);
    User getUser(int i);
    User getUser(String name, String lastname);
    void update(int i, User user);
    void delete(int i);
}
