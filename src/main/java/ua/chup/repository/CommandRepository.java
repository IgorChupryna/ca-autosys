package ua.chup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.chup.model.Command;

public interface CommandRepository extends JpaRepository<Command, Long> {

    @Query("SELECT u FROM Command u where u.name = :name")
    Command findByAdmin(@Param("name") String name);

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM Command u WHERE u.name = :name")
    boolean existsByName(@Param("name") String name);
}
