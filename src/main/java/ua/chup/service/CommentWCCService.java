package ua.chup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.chup.model.CommentWCC;
import ua.chup.repository.CommentWCCRepository;

import java.util.List;

@Service
public class CommentWCCService {

    @Autowired
    private CommentWCCRepository commentWCCRepository;

    @Transactional(readOnly = true)
    public CommentWCC getCommById(Long id) {
        return commentWCCRepository.getOne(id);
    }

    @Transactional(readOnly = false)
    public void deleteOne(Long id) {
        commentWCCRepository.delete(id);
    }

    @Transactional(readOnly = true)
    public CommentWCC getCommAdminByName(String name) {
        return commentWCCRepository.findByCommentWCC(name);
    }

    @Transactional
    public void addComm(CommentWCC commentCommand) {
        commentWCCRepository.save(commentCommand);
    }

    @Transactional
    public void updateComm(CommentWCC commentCommand) {
        commentWCCRepository.save(commentCommand);
    }

    @Transactional(readOnly = false)
    public void deleteAll() {
        commentWCCRepository.deleteAll();
    }

    @Transactional
    public List<CommentWCC> findAll() {
        return commentWCCRepository.findAll();
    }
}
