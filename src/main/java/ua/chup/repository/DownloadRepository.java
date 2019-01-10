package ua.chup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.chup.model.Download;

public interface DownloadRepository extends JpaRepository<Download, Long> {

@Query("SELECT u FROM Download u where u.name = :name")
Download findByDownload(@Param("name") String name);

@Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM Download u WHERE u.name = :name")
    boolean existsByName(@Param("name") String name);

}