package ua.chup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.chup.model.CommentWCC;


public interface CommentWCCRepository extends JpaRepository<CommentWCC, Long> {

    @Query("SELECT u FROM CommentWCC u")
    CommentWCC findByCommentWCC(@Param("name") String name);
}
