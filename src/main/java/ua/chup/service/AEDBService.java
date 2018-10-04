package ua.chup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.chup.model.AEDB;
import ua.chup.repository.AEDBRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class AEDBService {

    @Autowired
    private AEDBRepository aedbRepository;

    @Transactional(readOnly = true)
    public AEDB getAEDBByName(String name) {
        return aedbRepository.findByAEDB(name);
    }

    @Transactional(readOnly = true)
    public boolean existsByName(String name) {
        return aedbRepository.existsByName(name);
    }

    @Transactional
    public void addAEDB(AEDB aedb) {
        aedbRepository.save(aedb);
    }

    @Transactional
    public void updateAdmin(AEDB aedb) {
        aedbRepository.save(aedb);
    }

    @Transactional(readOnly = false)
    public void deleteAll(){
        aedbRepository.deleteAll();
    }
    @Transactional
    public List<AEDB> findAll() {
        return aedbRepository.findAll();
    }

    @Transactional
    public List<String> findAllName() {
        List<AEDB> aedb = findAll();
        List<String> strings=new ArrayList<>();
        for (AEDB a:aedb) {
            strings.add(a.getName());
        }
         return strings;
    }


}
