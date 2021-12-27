package jm.security.example.dao;

import jm.security.example.model.Role;
import jm.security.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public UserDaoImpl() {
    }

    @Override
    @Transactional
    public List<User> allUsers() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);

    }

    @Override
    public User getById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);

    }

    @Override
    public void delete(int id) {
        entityManager.remove(getById(id));

    }

    @Override
    public User getUserByName(String username) {
        return entityManager.find(User.class, username);
    }


//    private final Map<String, User> userMap = Collections.singletonMap("test",
//            new User(1L, "test", "test", Collections.singleton(new Role(1L, "ROLE_USER",users)))); // name - уникальное значение, выступает в качестве ключа Map
//
//    @Override
//    public User getUserByName(String name) {
//        if (!userMap.containsKey(name)) {
//            return null;
//        }
//
//        return userMap.get(name);
//    }
}

