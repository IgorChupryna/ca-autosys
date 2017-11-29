package ua.chup.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.chup.model.Util;

import java.util.List;

public interface UtilRepository  extends JpaRepository<Util, Long> {


    @Query("SELECT u FROM Util u WHERE u.name = :name")
    List<Util> findByName(@Param("name") Util util, Pageable pageable);

}
