package ua.chup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.chup.model.Administration;
import ua.chup.model.Installation;

public interface AdministrationRepository extends JpaRepository<Administration, Long> {

    @Query("SELECT u FROM Administration u where u.name = :name")
    Administration findByAdmin(@Param("name") String name);

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM Administration u WHERE u.name = :name")
    boolean existsByName(@Param("name") String name);
}
