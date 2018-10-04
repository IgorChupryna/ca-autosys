package ua.chup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.chup.model.EEM;
import ua.chup.repository.EEMRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class EEMService {

    @Autowired
    private EEMRepository eemRepository;

    @Transactional(readOnly = true)
    public EEM getEEMByName(String name) {
        return eemRepository.findByEEM(name);
    }

    @Transactional(readOnly = true)
    public boolean existsByName(String name) {
        return eemRepository.existsByName(name);
    }

    @Transactional
    public void addEEM(EEM eem) {
        eemRepository.save(eem);
    }

    @Transactional
    public void updateAdmin(EEM eem) {
        eemRepository.save(eem);
    }

    @Transactional(readOnly = false)
    public void deleteAll(){
        eemRepository.deleteAll();
    }
    @Transactional
    public List<EEM> findAll() {
        return eemRepository.findAll();
    }
    @Transactional
    public List<String> findAllName() {
        List<EEM> aedb = findAll();
        List<String> strings=new ArrayList<>();
        for (EEM a:aedb) {
            strings.add(a.getName());
        }
        return strings;
    }


}
