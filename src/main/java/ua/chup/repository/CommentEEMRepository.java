package ua.chup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.chup.model.CommentEEM;


public interface CommentEEMRepository extends JpaRepository<CommentEEM, Long> {

    @Query("SELECT u FROM CommentEEM u")
    CommentEEM findByCommentEEM(@Param("name") String name);
}
