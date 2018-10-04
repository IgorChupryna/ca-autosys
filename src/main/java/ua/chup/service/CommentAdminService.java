package ua.chup.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.chup.model.CommentAdmin;
import ua.chup.repository.CommentAdminRepository;


import java.util.List;

@Service
public class CommentAdminService {

    @Autowired
    private CommentAdminRepository commentAdminRepository;



    @Transactional(readOnly = true)
    public CommentAdmin getCommById(Long id) {
        return commentAdminRepository.getOne(id);
    }

    @Transactional(readOnly = false)
    public void deleteOne(Long id){
        commentAdminRepository.delete(id);
    }

    @Transactional(readOnly = true)
    public CommentAdmin getCommAdminByName(String name) {
        return commentAdminRepository.findByCommentAdmin(name);
    }

    @Transactional
    public void addComm(CommentAdmin commentAdmin) {
        commentAdminRepository.save(commentAdmin);
    }

    @Transactional
    public void updateComm(CommentAdmin commentAdmin) {
        commentAdminRepository.save(commentAdmin);
    }

    @Transactional(readOnly = false)
    public void deleteAll(){
        commentAdminRepository.deleteAll();
    }
    @Transactional
    public List<CommentAdmin> findAll() {
        return commentAdminRepository.findAll();
    }

}
