package jm.security.example.dao;

import jm.security.example.model.User;

import java.util.List;

public interface UserDao {
    List<User> allUsers();

    void saveUser(User user);

    User getById(long id);

    void update(long id, User updatedUser);

    void delete(long id);

    User getUserByName(String username);
}
