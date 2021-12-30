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
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public UserDaoImpl() {
    }

    @Override

    public List<User> allUsers() {
        return entityManager.createQuery("select distinct u from User u join fetch u.roles",
                User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);

    }

    @Override
    public User getById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void update(long id,User updatedUser) {
        User user = getById(id);
        user.setName(updatedUser.getName());
        user.setUsername(updatedUser.getUsername());
        user.setAge(updatedUser.getAge());
        user.setEmail(updatedUser.getEmail());
        if (updatedUser.getPassword() != "")
            user.setPassword(updatedUser.getPassword());
        user.setRoles(updatedUser.getRoles());

    }

    @Override
    public void delete(long id) {
        entityManager.createQuery("delete from User o where o.id=:id").setParameter("id", id).executeUpdate();

    }

    @Override
    public User getUserByName(String username) {
        return entityManager.createQuery(
                        "SELECT user FROM User user WHERE user.username =:username", User.class)
                .setParameter("username", username)
                .getSingleResult();
    }


}

