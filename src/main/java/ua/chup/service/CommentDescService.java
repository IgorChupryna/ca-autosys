package ua.chup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.chup.model.CommentDesc;
import ua.chup.repository.CommentDescRepository;


import java.util.List;
@Service
public class CommentDescService {
    @Autowired
    private CommentDescRepository commentDescRepository;



    @Transactional(readOnly = true)
    public CommentDesc getCommById(Long id) {
        return commentDescRepository.getOne(id);
    }

    @Transactional(readOnly = false)
    public void deleteOne(Long id){
        commentDescRepository.delete(id);
    }

    @Transactional(readOnly = true)
    public CommentDesc getCommByName(String name) {
        return commentDescRepository.findByComment(name);
    }

    @Transactional
    public void addComm(CommentDesc commentDesc) {
        commentDescRepository.save(commentDesc);
    }

    @Transactional
    public void updateComm(CommentDesc commentDesc) {
        commentDescRepository.save(commentDesc);
    }

    @Transactional(readOnly = false)
    public void deleteAll(){
        commentDescRepository.deleteAll();
    }
    @Transactional
    public List<CommentDesc> findAll() {
        return commentDescRepository.findAll();
    }

}
