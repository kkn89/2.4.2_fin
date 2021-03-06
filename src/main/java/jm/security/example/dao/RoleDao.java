package jm.security.example.dao;

import jm.security.example.model.Role;

import java.util.List;

public interface RoleDao {
    List<Role> allRoles();

    void add(Role role);

    void update(Role role);

    Role getById(int id);

    Role getByName(String roleName);
}
