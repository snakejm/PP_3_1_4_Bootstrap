package web.bootstrap.demo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import web.bootstrap.demo.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByUsername(String username);

    Optional<User> findUserByEmail(String email);

}
