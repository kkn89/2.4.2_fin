package jm.security.example.service;

import jm.security.example.dao.UserDao;
import jm.security.example.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> allUsers() {
        return null;
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public User getById(int id) {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public User getUserByName(String username) {
        return null;
    }
}
