package ua.chup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.chup.model.Util;
import ua.chup.repository.UtilRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UtilService {
    @Autowired
    private UtilRepository utilRepository;

    @Transactional
    public void deleteUtils(long[] idList) {
        for (long id : idList)
            utilRepository.delete(id);
    }

    @Transactional(readOnly=true)
    public List<Util> findAll(Pageable pageable) {
        return utilRepository.findAll(pageable).getContent();
    }
    @Transactional(readOnly=true)
    public List<Util> findAll() {
        return utilRepository.findAll();
    }
    @Transactional
    public void deleteAll() {
        utilRepository.deleteAll();
    }

    @Transactional
    public void addUtil(Util util) {
        utilRepository.save(util);
    }

    @Transactional(readOnly = true)
    public List<Util> findByName(Util util, Pageable pageable){
        return utilRepository.findByName(util,pageable);
    }

    @Transactional(readOnly = true)
    public long count() {
        return utilRepository.count();
    }

}
