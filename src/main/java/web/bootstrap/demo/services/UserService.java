package web.bootstrap.demo.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import web.bootstrap.demo.models.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    void addUser(User user);

    List<User> getAllUsers();

    User findUserById(long id);

    User findUserByFirstName(String firstName);

    User findUserByEmail(String email);

    void udpateUser(User user);

    void deleteAllUsers();

    void deleteUserById(long id);

}
