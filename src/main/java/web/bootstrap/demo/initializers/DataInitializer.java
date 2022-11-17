package web.bootstrap.demo.initializers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.bootstrap.demo.models.Role;
import web.bootstrap.demo.models.User;
import web.bootstrap.demo.services.RoleService;
import web.bootstrap.demo.services.UserService;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class DataInitializer {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public DataInitializer(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void init() {
        Role roleAdmin = roleService.findByRole("ROLE_ADMIN");
        if (roleAdmin == null) {
            roleAdmin = new Role("ROLE_ADMIN");
            roleService.addRole(roleAdmin);
        }
        Role roleUser = roleService.findByRole("ROLE_USER");
        if (roleUser == null) {
            roleUser = new Role("ROLE_USER");
            roleService.addRole(roleUser);
        }

        User admin = userService.findUserByFirstName("admin");
        if (admin == null) {
            admin = new User("admin", "admin", 35, "admin", "admin@mail.com",
                    List.of(roleAdmin, roleUser));
            userService.addUser(admin);
        }
        User user = userService.findUserByFirstName("user");
        if (user == null) {
            user = new User("user", "user", 30, "user", "user@mail.com",
                    List.of(roleUser));
            userService.addUser(user);
        }

//        TODO DELETE User a
        User a = userService.findUserByFirstName("a");
        if (a == null) {
            a = new User("a", "a", 31, "a", "a", List.of(roleAdmin, roleUser));
            userService.addUser(a);
        }

        //        TODO DELETE User b
        User b = userService.findUserByFirstName("b");
        if (b == null) {
            b = new User("b", "b", 31, "b", "b", List.of(roleUser));
            userService.addUser(b);
        }

    }
}
