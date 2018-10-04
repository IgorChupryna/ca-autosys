package ua.chup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.chup.model.Agent;

public interface AgentRepository extends JpaRepository<Agent, Long> {

    @Query("SELECT u FROM Agent u where u.name = :name")
    Agent findByAgent(@Param("name") String name);

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM Agent u WHERE u.name = :name")
    boolean existsByName(@Param("name") String name);
}
