package web.bootstrap.demo.services;

import web.bootstrap.demo.models.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    List<User> getAllUsers();

    User findUserByFirstName(String firstName);

    User findUserByEmail(String email);

    User findUserByUsername(String username);

    void updateUser(User user);

    void deleteUserById(long id);

}
