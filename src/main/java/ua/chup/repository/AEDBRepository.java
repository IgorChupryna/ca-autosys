package ua.chup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.chup.model.AEDB;

public interface AEDBRepository extends JpaRepository<AEDB, Long> {

    @Query("SELECT u FROM AEDB u where u.name = :name")
    AEDB findByAEDB(@Param("name") String name);

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM AEDB u WHERE u.name = :name")
    boolean existsByName(@Param("name") String name);
}
