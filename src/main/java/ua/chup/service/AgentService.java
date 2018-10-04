package ua.chup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.chup.model.Agent;
import ua.chup.repository.AgentRepository;


import java.util.ArrayList;
import java.util.List;


@Service
public class AgentService {

    @Autowired
    private AgentRepository agentRepository;

    @Transactional(readOnly = true)
    public Agent getAgentByName(String name) {
        return agentRepository.findByAgent(name);
    }

    @Transactional(readOnly = true)
    public boolean existsByName(String name) {
        return agentRepository.existsByName(name);
    }

    @Transactional
    public void addAgent(Agent agent) {
        agentRepository.save(agent);
    }

    @Transactional
    public void updateAdmin(Agent agent) {
        agentRepository.save(agent);
    }

    @Transactional(readOnly = false)
    public void deleteAll(){
        agentRepository.deleteAll();
    }
    @Transactional
    public List<Agent> findAll() {
        return agentRepository.findAll();
    }

    @Transactional
    public List<String> findAllName() {
        List<Agent> aedb = findAll();
        List<String> strings=new ArrayList<>();
        for (Agent a:aedb) {
            strings.add(a.getName());
        }
        return strings;
    }


}
