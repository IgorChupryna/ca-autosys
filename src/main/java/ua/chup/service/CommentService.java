package ua.chup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.chup.model.Comment;
import ua.chup.repository.CommentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Transactional(readOnly = true)
    public Comment getCommByName(String name) {
        return commentRepository.findByComment(name);
    }

    @Transactional(readOnly = true)
    public Comment getCommById(Long id) {
        return commentRepository.getOne(id);
    }

    @Transactional(readOnly = false)
    public void deleteOne(Long id){
        commentRepository.delete(id);
    }


    @Transactional
    public void addComm(Comment comment) {
        commentRepository.save(comment);
    }

    @Transactional
    public void updateComm(Comment comment) {
        commentRepository.save(comment);
    }

    @Transactional(readOnly = false)
    public void deleteAll(){
        commentRepository.deleteAll();
    }
    @Transactional
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }


}
