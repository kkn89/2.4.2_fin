package jm.security.example.dao;

import jm.security.example.model.User;

import java.util.List;

public interface UserDao {
    List<User> allUsers();

    void saveUser(User user);

    User getById(int id);

    void update(User user);

    void delete(int id);

    User getUserByName(String username);
}
