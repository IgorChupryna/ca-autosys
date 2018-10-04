package ua.chup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.chup.model.WCC;

public interface WCCRepository extends JpaRepository<WCC, Long> {

    @Query("SELECT u FROM WCC u where u.name = :name")
    WCC findByWCC(@Param("name") String name);

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM WCC u WHERE u.name = :name")
    boolean existsByName(@Param("name") String name);
}
