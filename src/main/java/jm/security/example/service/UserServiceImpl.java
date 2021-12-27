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
        return userDao.allUsers();
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);

    }

    @Override
    public User getById(int id) {
        return userDao.getById(id);
    }

    @Override
    public void update(User user) {
        userDao.update(user);

    }

    @Override
    public void delete(int id) {
        userDao.delete(id);

    }

    @Override
    public User getUserByName(String username) {
        return userDao.getUserByName(username);
    }
}
