package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDaoImp;
import web.model.User;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDaoImp userDaoImp;

    @Override
    public void create(User user) {
        userDaoImp.create(user);
    }

    @Override
    public void getUser(int i) {
        userDaoImp.getUser(i);
    }

    @Override
    public void getUser(String name, String lastname) {
        userDaoImp.getUser(name, lastname);
    }

    @Override
    public void update(int i, User user) {
        userDaoImp.update(i, user);
    }

    @Override
    public void delete(int i) {
        userDaoImp.delete(i);
    }
}
