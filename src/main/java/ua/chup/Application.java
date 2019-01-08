package ua.chup;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ua.chup.model.*;
import ua.chup.service.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class Application {
    public static Map<String, List<String>> menu = new HashMap<>();


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

    /*
    @Bean
    public CommandLineRunner demo(final UserService userService) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {

                userService.deleteAll();
                userService.addUser(new CustomUser("admin", "5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8", UserRole.ADMIN));
                userService.addUser(new CustomUser("user", "5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8", UserRole.USER));
            }
        };
    }
*/
    @Bean
    public CommandLineRunner demo(final CommandService commandService, final DescriptionService descriptionService, final InstallationService installationService,
                                  final WCCService wccService, final EEMService eemService, final AEDBService aedbService, final AgentService agentService, final AdministrationService administrationService) {
        return new CommandLineRunner() {

            @Override
            public void run(String... strings) throws Exception {

                menu.put("desc_m", getListName("Description"));
                menu.put("inst", getListName("Installation"));
                menu.put("adm", getListName("Administration"));
                menu.put("comm1", getListName("Command1"));
                menu.put("comm2", getListName("Command2"));
                menu.put("comm3", getListName("Command3"));
                menu.put("comm4", getListName("Command4"));
                menu.put("comm5", getListName("Command5"));
                menu.put("agt", getListName("Agent"));
                menu.put("eem_m", getListName("EEM"));
                menu.put("wcc_m", getListName("WCC"));
                menu.put("aedb_m", getListName("AEDB"));

            }

            private List<String> getListName(String name) {
                List<String> list = null;
                if (Description.class.getSimpleName().equals(name)) {
                    list = descriptionService.findAllName();

                } else if (Installation.class.getSimpleName().equals(name)) {
                    list = installationService.findAllName();

                } else if (Administration.class.getSimpleName().equals(name)) {
                    list = administrationService.findAllName();

                } else if (name.length() == 8 && Command.class.getSimpleName().equals(name.substring(0, name.length() - 1))) {
                    String idx = name.substring(7);
                    if (idx.equals("1"))
                        list = commandService.findAllName("Maintain System");
                    else if (idx.equals("2"))
                        list = commandService.findAllName("Maintain Databases");
                    else if (idx.equals("3"))
                        list = commandService.findAllName("Manage Security");
                    else if (idx.equals("4"))
                        list = commandService.findAllName("Define Objects");
                    else if (idx.equals("5"))
                        list = commandService.findAllName("Monitor and Report");


                } else if (Agent.class.getSimpleName().equals(name)) {
                    list = agentService.findAllName();

                } else if (EEM.class.getSimpleName().equals(name)) {
                    list = eemService.findAllName();

                } else if (WCC.class.getSimpleName().equals(name)) {
                    list = wccService.findAllName();

                } else if (AEDB.class.getSimpleName().equals(name)) {
                    list = aedbService.findAllName();

                }
                return list;
            }


        };
    }


}