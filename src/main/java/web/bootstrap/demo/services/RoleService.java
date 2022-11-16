package web.bootstrap.demo.services;

import org.springframework.security.core.GrantedAuthority;
import web.bootstrap.demo.models.Role;

import java.util.List;

public interface RoleService {

    void addRole(Role role);

    Role findByRole(String role);

    List<Role> listRoles();

    List<? extends GrantedAuthority> mapRolesToAuthorities(List<Role> roles);
}
