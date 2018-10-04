package ua.chup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.chup.model.Command;
import ua.chup.repository.CommandRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class CommandService {

    @Autowired
    private CommandRepository commandRepository;

    @Transactional(readOnly = true)
    public Command getAdminByName(String name) {
        return commandRepository.findByAdmin(name);
    }

    @Transactional(readOnly = true)
    public boolean existsByName(String name) {
        return commandRepository.existsByName(name);
    }

    @Transactional
    public void addAdmin(Command command) {
        commandRepository.save(command);
    }

    @Transactional
    public void updateAdmin(Command command) {
        commandRepository.save(command);
    }

    @Transactional(readOnly = false)
    public void deleteAll(){
        commandRepository.deleteAll();
    }
    @Transactional
    public List<Command> findAll() {
        return commandRepository.findAll();
    }

    @Transactional
    public List<String> findAllName() {
        List<Command> aedb = findAll();
        List<String> strings=new ArrayList<>();
        for (Command a:aedb) {
            strings.add(a.getName());
        }
        return strings;
    }

    @Transactional
    public List<String> findAllName(String type) {
        List<Command> aedb = findAll();
        List<String> strings=new ArrayList<>();
        for (Command a:aedb) {
            if(a.getType().equals(type))
            strings.add(a.getName());
        }
        return strings;
    }

}
