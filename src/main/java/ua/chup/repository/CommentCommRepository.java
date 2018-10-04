package ua.chup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.chup.model.CommentCommand;

public interface CommentCommRepository  extends JpaRepository<CommentCommand, Long> {

    @Query("SELECT u FROM CommentCommand u")
    CommentCommand findByCommentComm(@Param("name") String name);
}
