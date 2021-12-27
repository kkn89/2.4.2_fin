package jm.security.example.service;

import jm.security.example.model.Role;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface RoleService {
    List<Role> allRoles();


}
