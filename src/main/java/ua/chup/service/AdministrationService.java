package ua.chup.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.chup.model.Administration;
import ua.chup.repository.AdministrationRepository;


import java.util.ArrayList;
import java.util.List;

@Service
public class AdministrationService {
    @Autowired
    private AdministrationRepository administrationRepository;

    @Transactional(readOnly = true)
    public Administration getAdminByName(String name) {
        return administrationRepository.findByAdmin(name);
    }

    @Transactional(readOnly = true)
    public boolean existsByName(String name) {
        return administrationRepository.existsByName(name);
    }

    @Transactional
    public void addAdmin(Administration administration) {
        administrationRepository.save(administration);
    }

    @Transactional
    public void updateAdmin(Administration administration) {
        administrationRepository.save(administration);
    }

    @Transactional(readOnly = false)
    public void deleteAll(){
        administrationRepository.deleteAll();
    }
    @Transactional
    public List<Administration> findAll() {
        return administrationRepository.findAll();
    }


    @Transactional
    public List<String> findAllName() {
        List<Administration> aedb = findAll();
        List<String> strings=new ArrayList<>();
        for (Administration a:aedb) {
            strings.add(a.getName());
        }
        return strings;
    }

}
