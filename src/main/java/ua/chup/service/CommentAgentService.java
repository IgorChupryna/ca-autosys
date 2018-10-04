package ua.chup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.chup.model.CommentAgent;
import ua.chup.repository.CommentAgentRepository;


import java.util.List;

@Service
public class CommentAgentService {

    @Autowired
    private CommentAgentRepository commentAgentRepository;

    @Transactional(readOnly = true)
    public CommentAgent getCommById(Long id) {
        return commentAgentRepository.getOne(id);
    }

    @Transactional(readOnly = false)
    public void deleteOne(Long id) {
        commentAgentRepository.delete(id);
    }

    @Transactional(readOnly = true)
    public CommentAgent getCommAdminByName(String name) {
        return commentAgentRepository.findByCommentAgt(name);
    }

    @Transactional
    public void addComm(CommentAgent commentCommand) {
        commentAgentRepository.save(commentCommand);
    }

    @Transactional
    public void updateComm(CommentAgent commentCommand) {
        commentAgentRepository.save(commentCommand);
    }

    @Transactional(readOnly = false)
    public void deleteAll() {
        commentAgentRepository.deleteAll();
    }

    @Transactional
    public List<CommentAgent> findAll() {
        return commentAgentRepository.findAll();
    }
}
