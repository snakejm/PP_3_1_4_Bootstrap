package web.bootstrap.demo.services.impl;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.bootstrap.demo.models.User;
import web.bootstrap.demo.repositories.UserRepository;
import web.bootstrap.demo.services.UserService;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserByFirstName(String firstName) {
        return userRepository.findUserByFirstName(firstName).orElse(null);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public User findUserByUsername(String username) {
        User user = userRepository.findUserByEmail(username).orElseThrow(() -> new UsernameNotFoundException(username));
        Hibernate.initialize(user.getRoles());
        return user;
    }

    @Override
    @Transactional
    public void updateUser(User updateUser) {
        updateUser.setPassword((updateUser.getPassword() != null && !updateUser.getPassword().trim().equals("")) ?
                passwordEncoder.encode(updateUser.getPassword()) :
                userRepository.findUserById(updateUser.getId()).getPassword());
        userRepository.save(updateUser);
    }

    @Override
    @Transactional
    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }

}
