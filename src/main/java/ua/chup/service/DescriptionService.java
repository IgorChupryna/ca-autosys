package ua.chup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.chup.model.Description;
import ua.chup.repository.DescriptionRepository;

import java.util.List;


@Service
public class DescriptionService {
    @Autowired
    private DescriptionRepository descriptionRepository;

    @Transactional(readOnly = true)
    public Description getUserByName(String name) {
        return descriptionRepository.findByName(name);
    }

    @Transactional(readOnly = true)
    public boolean existsByName(String name) {
        return descriptionRepository.existsByName(name);
    }

    @Transactional
    public void addDesc(Description description) {
        descriptionRepository.save(description);
    }

    @Transactional
    public void updateDesc(Description description) {
        descriptionRepository.save(description);
    }

    @Transactional(readOnly = false)
    public void deleteAll(){
        descriptionRepository.deleteAll();
    }
    @Transactional
    public List<Description> findAll() {
        return descriptionRepository.findAll();
    }
}
