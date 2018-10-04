package ua.chup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.chup.model.CommentAEDB;
import ua.chup.repository.CommentAEDBRepository;

import java.util.List;

@Service
public class CommentAEDBService {

    @Autowired
    private CommentAEDBRepository commentAEDBRepository;

    @Transactional(readOnly = true)
    public CommentAEDB getCommById(Long id) {
        return commentAEDBRepository.getOne(id);
    }

    @Transactional(readOnly = false)
    public void deleteOne(Long id) {
        commentAEDBRepository.delete(id);
    }

    @Transactional(readOnly = true)
    public CommentAEDB getCommAdminByName(String name) {
        return commentAEDBRepository.findByCommentAEDB(name);
    }

    @Transactional
    public void addComm(CommentAEDB commentCommand) {
        commentAEDBRepository.save(commentCommand);
    }

    @Transactional
    public void updateComm(CommentAEDB commentCommand) {
        commentAEDBRepository.save(commentCommand);
    }

    @Transactional(readOnly = false)
    public void deleteAll() {
        commentAEDBRepository.deleteAll();
    }

    @Transactional
    public List<CommentAEDB> findAll() {
        return commentAEDBRepository.findAll();
    }
}
