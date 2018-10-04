package ua.chup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.chup.model.CommentCommand;
import ua.chup.repository.CommentCommRepository;

import java.util.List;

@Service
public class CommentCommService {

    @Autowired
    private CommentCommRepository commentCommRepository;

    @Transactional(readOnly = true)
    public CommentCommand getCommById(Long id) {
        return commentCommRepository.getOne(id);
    }

    @Transactional(readOnly = false)
    public void deleteOne(Long id) {
        commentCommRepository.delete(id);
    }

    @Transactional(readOnly = true)
    public CommentCommand getCommAdminByName(String name) {
        return commentCommRepository.findByCommentComm(name);
    }

    @Transactional
    public void addComm(CommentCommand commentCommand) {
        commentCommRepository.save(commentCommand);
    }

    @Transactional
    public void updateComm(CommentCommand commentCommand) {
        commentCommRepository.save(commentCommand);
    }

    @Transactional(readOnly = false)
    public void deleteAll() {
        commentCommRepository.deleteAll();
    }

    @Transactional
    public List<CommentCommand> findAll() {
        return commentCommRepository.findAll();
    }
}
