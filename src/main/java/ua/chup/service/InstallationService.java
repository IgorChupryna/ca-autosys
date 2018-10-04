package ua.chup.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.chup.model.Installation;
import ua.chup.repository.InstallationRepository;


import java.util.ArrayList;
import java.util.List;

@Service
public class InstallationService {
    @Autowired
    private InstallationRepository installationRepository;

    @Transactional(readOnly = true)
    public Installation getInstallByName(String name) {
        return installationRepository.findByInstall(name);
    }

    @Transactional(readOnly = true)
    public boolean existsByName(String name) {
        return installationRepository.existsByName(name);
    }

    @Transactional
    public void addDesc(Installation installation) {
        installationRepository.save(installation);
    }

    @Transactional
    public void updateDesc(Installation installation) {
        installationRepository.save(installation);
    }

    @Transactional(readOnly = false)
    public void deleteAll(){
        installationRepository.deleteAll();
    }
    @Transactional
    public List<Installation> findAll() {
        return installationRepository.findAll();
    }

    @Transactional
    public List<String> findAllName() {
        List<Installation> aedb = findAll();
        List<String> strings=new ArrayList<>();
        for (Installation a:aedb) {
            strings.add(a.getName());
        }
        return strings;
    }


}
