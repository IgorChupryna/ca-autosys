package ua.chup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.chup.model.CommentDesc;

public interface CommentDescRepository extends JpaRepository<CommentDesc, Long> {

    @Query("SELECT u FROM CommentDesc u")
    CommentDesc findByComment(@Param("name") String name);

}
