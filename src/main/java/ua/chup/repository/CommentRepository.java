package ua.chup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.chup.model.Comment;


public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("SELECT u FROM Comment u")
    Comment findByComment(@Param("name") String name);

}
