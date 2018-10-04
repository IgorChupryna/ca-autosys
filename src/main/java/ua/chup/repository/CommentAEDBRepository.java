package ua.chup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.chup.model.CommentAEDB;


public interface CommentAEDBRepository extends JpaRepository<CommentAEDB, Long> {

    @Query("SELECT u FROM CommentAEDB u")
    CommentAEDB findByCommentAEDB(@Param("name") String name);
}
