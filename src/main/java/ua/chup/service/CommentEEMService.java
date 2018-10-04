package ua.chup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.chup.model.CommentEEM;
import ua.chup.repository.CommentEEMRepository;

import java.util.List;

@Service
public class CommentEEMService {

    @Autowired
    private CommentEEMRepository commentEEMRepository;

    @Transactional(readOnly = true)
    public CommentEEM getCommById(Long id) {
        return commentEEMRepository.getOne(id);
    }

    @Transactional(readOnly = false)
    public void deleteOne(Long id) {
        commentEEMRepository.delete(id);
    }

    @Transactional(readOnly = true)
    public CommentEEM getCommAdminByName(String name) {
        return commentEEMRepository.findByCommentEEM(name);
    }

    @Transactional
    public void addComm(CommentEEM commentCommand) {
        commentEEMRepository.save(commentCommand);
    }

    @Transactional
    public void updateComm(CommentEEM commentCommand) {
        commentEEMRepository.save(commentCommand);
    }

    @Transactional(readOnly = false)
    public void deleteAll() {
        commentEEMRepository.deleteAll();
    }

    @Transactional
    public List<CommentEEM> findAll() {
        return commentEEMRepository.findAll();
    }
}
