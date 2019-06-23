package pl.konopka.myfilmweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.konopka.myfilmweb.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String userName);
    List<User> getAllByRoleIn(List<String> roles);
}
