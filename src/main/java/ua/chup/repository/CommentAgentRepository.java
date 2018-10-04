package ua.chup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.chup.model.CommentAgent;


public interface CommentAgentRepository extends JpaRepository<CommentAgent, Long> {

    @Query("SELECT u FROM CommentAgent u")
    CommentAgent findByCommentAgt(@Param("name") String name);
}
