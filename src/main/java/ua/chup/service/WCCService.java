package ua.chup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.chup.model.WCC;
import ua.chup.repository.WCCRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class WCCService {

    @Autowired
    private WCCRepository wccRepository;

    @Transactional(readOnly = true)
    public WCC getWCCByName(String name) {
        return wccRepository.findByWCC(name);
    }

    @Transactional(readOnly = true)
    public boolean existsByName(String name) {
        return wccRepository.existsByName(name);
    }

    @Transactional
    public void addWCC(WCC wcc) {
        wccRepository.save(wcc);
    }

    @Transactional
    public void updateAdmin(WCC wcc) {
        wccRepository.save(wcc);
    }

    @Transactional(readOnly = false)
    public void deleteAll(){
        wccRepository.deleteAll();
    }
    @Transactional
    public List<WCC> findAll() {
        return wccRepository.findAll();
    }

    @Transactional
    public List<String> findAllName() {
        List<WCC> aedb = findAll();
        List<String> strings=new ArrayList<>();
        for (WCC a:aedb) {
            strings.add(a.getName());
        }
        return strings;
    }

}
