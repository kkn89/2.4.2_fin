package jm.security.example.service;

import jm.security.example.dao.UserDao;
import jm.security.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserDao userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public List<User> allUsers() {
        return userDao.allUsers();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.saveUser(user);

    }

    @Override
    @Transactional
    public User getById(long id) {
        return userDao.getById(id);
    }

    @Override
    @Transactional
    public void update(long id, User updatedUser) {
        if(updatedUser.getPassword() != ""){
            updatedUser.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
        }
        userDao.update(id, updatedUser);

    }

    @Override
    @Transactional
    public void delete(long id) {
        userDao.delete(id);

    }

    @Override
    @Transactional
    public User getUserByName(String username) {
        return userDao.getUserByName(username);
    }
}
