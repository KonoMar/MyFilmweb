package pl.konopka.myfilmweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.konopka.myfilmweb.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findById(Long id);
}
