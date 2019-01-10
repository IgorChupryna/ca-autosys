package ua.chup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.chup.Application;
import ua.chup.model.*;
import ua.chup.service.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private UserService userService;
    @Autowired
    private UtilService utilService;
    @Autowired
    private DescriptionService descriptionService;
    @Autowired
    private InstallationService installationService;
    @Autowired
    private CommandService commandService;
    @Autowired
    private AgentService agentService;
    @Autowired
    private AdministrationService administrationService;
    @Autowired
    private WCCService wccService;
    @Autowired
    private AEDBService aedbService;
    @Autowired
    private EEMService eemService;


    @RequestMapping("/first")
    public String loginPage(Model model) {
        model.addAttribute("login", getLoginName());
        List<Util> utils = utilService.findAll();
        model.addAttribute("utils", utils);
        return "login";
    }


    @RequestMapping("/commands")
    public String commPage() {
        return "commands";
    }


    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("login", getLoginName());
        for (Map.Entry<String, List<String>> table : Application.menu.entrySet()) {
            model.addAttribute(table.getKey(),table.getValue());
        }
        return "first";
    }


    @RequestMapping("/second")
    public String second(Model model) {
        model.addAttribute("login", getLoginName());
        for (Map.Entry<String, List<String>> table : Application.menu.entrySet()) {
            model.addAttribute(table.getKey(),table.getValue());
        }
        return "second";
    }


    @RequestMapping(value = "/update")
    public String update(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String login = user.getUsername();

        CustomUser dbUser = userService.getUserByLogin(login);

        model.addAttribute("login", login);
        model.addAttribute("roles", user.getAuthorities());
        model.addAttribute("email", dbUser.getEmail());
        model.addAttribute("phone", dbUser.getPhone());
        for (Map.Entry<String, List<String>> table : Application.menu.entrySet()) {
            model.addAttribute(table.getKey(),table.getValue());
        }

        return "index";
    }


    @RequestMapping(value = "/contact/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> delete(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            utilService.deleteUtils(toDelete);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/contact/add", method = RequestMethod.POST)
    public String contactAdd(@RequestParam String name,
                             @RequestParam String description,
                             @RequestParam String example,
                             @RequestParam String path_v) {
        Util contact = new Util(name, description, example, path_v);
        utilService.addUtil(contact);

        return "redirect:/";
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestParam(required = false) String email, @RequestParam(required = false) String phone,Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String login = user.getUsername();

        CustomUser dbUser = userService.getUserByLogin(login);
        dbUser.setEmail(email);
        dbUser.setPhone(phone);

        userService.updateUser(dbUser);
        for (Map.Entry<String, List<String>> table : Application.menu.entrySet()) {
            model.addAttribute(table.getKey(),table.getValue());
        }
        return "redirect:/";
    }


    @RequestMapping(value = "/newuser", method = RequestMethod.POST)
    public String update(@RequestParam String login,
                         @RequestParam String password,
                         @RequestParam(required = false) String email,
                         @RequestParam(required = false) String phone,
                         Model model, @RequestParam String options) {
        if (userService.existsByLogin(login)) {
            model.addAttribute("exists", true);
            return "register";
        }



        ShaPasswordEncoder encoder = new ShaPasswordEncoder();
        String passHash = encoder.encodePassword(password, null);

        CustomUser dbUser = new CustomUser(login, passHash, UserRole.USER, email, phone);
        dbUser.setPathAvatar(options);
        userService.addUser(dbUser);

        return "redirect:/";
    }

    @RequestMapping("/register")
    public String register(Model model) {
        model.addAttribute("login", getLoginName());
        for (Map.Entry<String, List<String>> table : Application.menu.entrySet()) {
            model.addAttribute(table.getKey(),table.getValue());
        }
        return "register";
    }

    @RequestMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("login", getLoginName());
        for (Map.Entry<String, List<String>> table : Application.menu.entrySet()) {
            model.addAttribute(table.getKey(),table.getValue());
        }
        return "admin";
    }

    @RequestMapping("/Installation")
    public String installation(@RequestParam("name") String name, Model model) {
        model.addAttribute("login", getLoginName());
        for (Map.Entry<String, List<String>> table : Application.menu.entrySet()) {
            model.addAttribute(table.getKey(),table.getValue());
        }

        Installation install = installationService.getInstallByName(name);
        model.addAttribute("install", install);
        return "installation";
    }

    @RequestMapping("/Description")
    public String description(@RequestParam("name") String name, Model model) {

        model.addAttribute("login", getLoginName());
        for (Map.Entry<String, List<String>> table : Application.menu.entrySet()) {
            model.addAttribute(table.getKey(),table.getValue());
        }
        Description desc = descriptionService.getUserByName(name);
        model.addAttribute("desc", desc);
        return "description";
    }

    @RequestMapping("/table")
    public String list(@RequestParam("name") String name, @RequestParam("view") String view, Model model) {
        model.addAttribute("login", getLoginName());
        for (Map.Entry<String, List<String>> table : Application.menu.entrySet()) {
            model.addAttribute(table.getKey(),table.getValue());
        }

        String shemas = "";
        List<?> list = null;
        if (Description.class.getSimpleName().equals(name)) {
            list = descriptionService.findAll();
            shemas = "Description";
        } else if (Installation.class.getSimpleName().equals(name)) {
            list = installationService.findAll();
            shemas = "Installation";
        } else if (Administration.class.getSimpleName().equals(name)) {
            list = administrationService.findAll();
            shemas = "Administration";
        } else if (Command.class.getSimpleName().equals(name)) {
            list = commandService.findAll();
            shemas = "Command";
        } else if (Agent.class.getSimpleName().equals(name)) {
            list = agentService.findAll();
            shemas = "Agent";
        }else if (EEM.class.getSimpleName().equals(name)) {
            list = eemService.findAll();
            shemas = "EEM";
        }else if (WCC.class.getSimpleName().equals(name)) {
            list = wccService.findAll();
            shemas = "WCC";
        }else if (AEDB.class.getSimpleName().equals(name)) {
            list = aedbService.findAll();
            shemas = "AEDB";
        }


        model.addAttribute("list", list);
        model.addAttribute("shemas", shemas);
        model.addAttribute("view", view);
        return "table";
    }

    @RequestMapping("/unauthorized")
    public String unauthorized(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("login", user.getUsername());
        for (Map.Entry<String, List<String>> table : Application.menu.entrySet()) {
            model.addAttribute(table.getKey(),table.getValue());
        }
        return "unauthorized";
    }

    @RequestMapping("/Administration")
    public String administration(@RequestParam("name") String name, Model model) {
        model.addAttribute("login", getLoginName());
        for (Map.Entry<String, List<String>> table : Application.menu.entrySet()) {
            model.addAttribute(table.getKey(),table.getValue());
        }
        Administration administration = administrationService.getAdminByName(name);
        model.addAttribute("administration", administration);
        return "administration";
    }

    public static String getLoginName(){
        String login = null;
        Object sc = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = null;
        if (sc instanceof User) {
            user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            login = user.getUsername();
        }
        return login;
    }

}
