package ua.chup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.chup.Application;
import ua.chup.model.*;
import ua.chup.service.*;
import java.util.List;
import java.util.Map;

import static ua.chup.controller.MainController.getLoginName;

@Controller
public class AdministrationController {
    @Autowired
    private UserService userService;
    @Autowired
    private CommandService commandService;
    @Autowired
    private AgentService agentService;
    @Autowired
    private WCCService wccService;
    @Autowired
    private AEDBService aedbService;
    @Autowired
    private EEMService eemService;
    @Autowired
    private DescriptionService descriptionService;
    @Autowired
    private InstallationService installationService;
    @Autowired
    private AdministrationService administrationService;




    @RequestMapping("/Command")
    public String command(@RequestParam("name") String name, Model model) {
        model.addAttribute("login", getLoginName());

        for (Map.Entry<String, List<String>> table : Application.menu.entrySet()) {
            model.addAttribute(table.getKey(),table.getValue());
        }

        Command command = commandService.getAdminByName(name);
        model.addAttribute("command", command);
        return "command";
    }


    @RequestMapping("/Agent")
    public String agent(@RequestParam("name") String name, Model model) {
        model.addAttribute("login", getLoginName());
        for (Map.Entry<String, List<String>> table : Application.menu.entrySet()) {
            model.addAttribute(table.getKey(),table.getValue());
        }

        Agent agent = agentService.getAgentByName(name);
        model.addAttribute("agent", agent);
        return "agent";
    }

    @RequestMapping("/WCC")
    public String wcc(@RequestParam("name") String name, Model model) {
        model.addAttribute("login", getLoginName());
        for (Map.Entry<String, List<String>> table : Application.menu.entrySet()) {
            model.addAttribute(table.getKey(),table.getValue());
        }

        WCC wcc = wccService.getWCCByName(name);
        model.addAttribute("wcc", wcc);
        return "wcc";
    }

    @RequestMapping("/AEDB")
    public String aedb(@RequestParam("name") String name, Model model) {
        model.addAttribute("login", getLoginName());
        for (Map.Entry<String, List<String>> table : Application.menu.entrySet()) {
            model.addAttribute(table.getKey(),table.getValue());
        }

        AEDB aedb = aedbService.getAEDBByName(name);
        model.addAttribute("aedb", aedb);
        return "aedb";
    }

    @RequestMapping("/EEM")
    public String eem(@RequestParam("name") String name, Model model) {
        model.addAttribute("login", getLoginName());
        for (Map.Entry<String, List<String>> table : Application.menu.entrySet()) {
            model.addAttribute(table.getKey(),table.getValue());
        }

        EEM eem = eemService.getEEMByName(name);
        model.addAttribute("eem", eem);
        return "eem";
    }



    @RequestMapping("/users")
    public String userPage(Model model) {
        model.addAttribute("login", getLoginName());
        for (Map.Entry<String, List<String>> table : Application.menu.entrySet()) {
            model.addAttribute(table.getKey(),table.getValue());
        }
        return "users";
    }
    @RequestMapping("/sendmail")
    public String mailPage(Model model) {
        model.addAttribute("login", getLoginName());
        for (Map.Entry<String, List<String>> table : Application.menu.entrySet()) {
            model.addAttribute(table.getKey(),table.getValue());
        }

        return "sendmail";
    }
    @RequestMapping("/content")
    public String contPage(Model model) {
        model.addAttribute("login", getLoginName());
        for (Map.Entry<String, List<String>> table : Application.menu.entrySet()) {
            model.addAttribute(table.getKey(),table.getValue());
        }

        return "content";
    }

    @RequestMapping("/contact_add_page")
    public String contactAddPage(Model model) {
        model.addAttribute("login", getLoginName());
        for (Map.Entry<String, List<String>> table : Application.menu.entrySet()) {
            model.addAttribute(table.getKey(),table.getValue());
        }

        return "contact_add_page";
    }

    @RequestMapping(value = "/contact_add_page", method = RequestMethod.POST)
    public String update(@RequestParam String login,
                         @RequestParam String password,
                         @RequestParam(required = false) String email,
                         @RequestParam(required = false) String phone,
                         Model model, @RequestParam String options) {
        if (userService.existsByLogin(login)) {
            model.addAttribute("exists", true);
            return "contact_add_page";
        }

        ShaPasswordEncoder encoder = new ShaPasswordEncoder();
        String passHash = encoder.encodePassword(password, null);

        CustomUser dbUser = new CustomUser(login, passHash, UserRole.USER, email, phone);
        dbUser.setPathAvatar(options);
        userService.addUser(dbUser);

        return "redirect:/";
    }

}
