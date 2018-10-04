package ua.chup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.chup.model.Installation;

public interface InstallationRepository  extends JpaRepository<Installation, Long> {

    @Query("SELECT u FROM Installation u where u.name = :name")
    Installation findByInstall(@Param("name") String name);

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM Installation u WHERE u.name = :name")
    boolean existsByName(@Param("name") String name);



}
