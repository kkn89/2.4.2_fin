package jm.security.example.dao;

import jm.security.example.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class RoleDaoImpl implements RoleDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public RoleDaoImpl() {
    }

    @Override
    @Transactional
    public List<Role> allRoles() {
        return entityManager.createQuery("FROM Role", Role.class).getResultList();
    }

}
