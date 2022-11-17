package web.bootstrap.demo.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import web.bootstrap.demo.models.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    void addUser(User user);

    List<User> getAllUsers();

    User findUserByFirstName(String firstName);

    User findUserByEmail(String email);

    void updateUser(User user);

    void deleteUserById(long id);

}
