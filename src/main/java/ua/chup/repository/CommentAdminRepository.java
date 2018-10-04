package ua.chup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.chup.model.CommentAdmin;

public interface CommentAdminRepository  extends JpaRepository<CommentAdmin, Long> {
    @Query("SELECT u FROM CommentAdmin u")
    CommentAdmin findByCommentAdmin(@Param("name") String name);
}
