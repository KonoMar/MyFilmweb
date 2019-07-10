package pl.konopka.myfilmweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.konopka.myfilmweb.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String userName);
}
