package jm.security.example.service;

import jm.security.example.dao.RoleDao;
import jm.security.example.model.Role;

import javax.transaction.Transactional;
import java.util.List;

public class RoleServiceImpl implements RoleService{
    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    @Transactional
    public List<Role> allRoles() {
        return roleDao.allRoles();
    }
}
