package ua.chup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.chup.model.Description;

public interface DescriptionRepository extends JpaRepository<Description, Long> {
    @Query("SELECT u FROM Description u where u.name = :name")
    Description findByName(@Param("name") String name);

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM Description u WHERE u.name = :name")
    boolean existsByName(@Param("name") String name);

}
