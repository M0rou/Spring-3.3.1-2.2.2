package web.service;


import web.model.User;

public interface UserService {
    void create(User user);
    void getUser(int i);
    void getUser(String name, String lastname);
    void update(int i, User user);
    void delete(int i);
}
