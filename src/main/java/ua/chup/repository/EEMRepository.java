package ua.chup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.chup.model.EEM;

public interface EEMRepository extends JpaRepository<EEM, Long> {

    @Query("SELECT u FROM EEM u where u.name = :name")
    EEM findByEEM(@Param("name") String name);

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM EEM u WHERE u.name = :name")
    boolean existsByName(@Param("name") String name);
}
