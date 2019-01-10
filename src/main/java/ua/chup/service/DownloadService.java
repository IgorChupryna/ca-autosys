package ua.chup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.chup.model.Download;
import ua.chup.repository.DownloadRepository;
import java.util.ArrayList;
import java.util.List;

@Service
public class DownloadService {
    @Autowired
    private DownloadRepository downloadRepository;

    @Transactional(readOnly = true)
    public Download getDownloadByName(String name) {
        return downloadRepository.findByDownload(name);
    }

    @Transactional(readOnly = true)
    public boolean existsByName(String name) {
        return downloadRepository.existsByName(name);
    }

    @Transactional
    public void addDownload(Download download) {
        downloadRepository.save(download);
    }

    @Transactional
    public void updateAdmin(Download download) {
        downloadRepository.save(download);
    }

    @Transactional(readOnly = false)
    public void deleteAll(){
        downloadRepository.deleteAll();
    }
    @Transactional
    public List<Download> findAll() {
        return downloadRepository.findAll();
    }
    @Transactional
    public List<String> findAllName() {
        List<Download> aedb = findAll();
        List<String> strings=new ArrayList<>();
        for (Download a:aedb) {
            strings.add(a.getName());
        }
        return strings;
    }
}
