package ua.chup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.chup.model.Util;
import ua.chup.repository.UtilRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UtilService {
    @Autowired
    private UtilRepository utilRepository;

    @Transactional
    public void addUtil(Util util) {
        utilRepository.save(util);
    }

}
