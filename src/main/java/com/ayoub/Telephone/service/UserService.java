package com.ayoub.Telephone.service;

import com.ayoub.Telephone.entities.Role;
import com.ayoub.Telephone.entities.User;

public interface UserService {
    void deleteAllusers();
    void deleteAllRoles();
    User saveUser(User user);
    User findUserByUsername (String username);
    Role addRole(Role role);
    User addRoleToUser(String username, String rolename);

}
