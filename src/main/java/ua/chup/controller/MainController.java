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
    static final int DEFAULT_GROUP_ID = -1;
    static final int ITEMS_PER_PAGE = 6;
    @Autowired
    private UserService userService;
    @Autowired
    private UtilService utilService;
    @Autowired
    private DescriptionService descriptionService;
    @Autowired
    private InstallationService installationService;
    @Autowired
    private CommentService commentService;
    @Autowired
    CommandService commandService;
    @Autowired
    AgentService agentService;
    @Autowired
    private CommentDescService commentDescService;
    @Autowired
    private AdministrationService administrationService;
    @Autowired
    private CommentAdminService commentAdminService;

    @Autowired
    private CommentCommService commentCommService;

    @Autowired
    private CommentAgentService commentAgentService;

    @Autowired
    private CommentAEDBService commentAEDBService;
    @Autowired
    private CommentEEMService commentEEMService;
    @Autowired
    private CommentWCCService commentWCCService;

    @Autowired
    WCCService wccService;
    @Autowired
    AEDBService aedbService;
    @Autowired
    EEMService eemService;


    @RequestMapping("/first")
    public String loginPage(Model model) {
        String login = null;
        Object sc = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (sc instanceof User) {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            login = user.getUsername();
        }
        model.addAttribute("login", login);
        List<Util> utils = utilService.findAll();
        model.addAttribute("utils", utils);

        return "login";
    }


    @RequestMapping("/commands")
    public String commPage(Model model) {
        return "commands";
    }


    @RequestMapping("/")
    public String index(Model model) {
        String login = null;
        Object sc = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = null;
        if (sc instanceof User) {
            user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            login = user.getUsername();
        }
        model.addAttribute("login", login);


        return "first";
    }


    @RequestMapping("/second")
    public String second(Model model) {
        String login = null;
        Object sc = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = null;
        if (sc instanceof User) {
            user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            login = user.getUsername();
        }
        model.addAttribute("login", login);


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
    public String update(@RequestParam(required = false) String email, @RequestParam(required = false) String phone) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String login = user.getUsername();

        CustomUser dbUser = userService.getUserByLogin(login);
        dbUser.setEmail(email);
        dbUser.setPhone(phone);

        userService.updateUser(dbUser);

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
    public String register() {
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


    @RequestMapping(value = "/adddComment")
    public String adddComment(@RequestParam("name") String name, @RequestParam("id") Integer id, @RequestParam(required = false) String body, @RequestParam String table) {
        String login = null;
        Object sc = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = null;
        if (sc instanceof User) {
            user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            login = user.getUsername();
        }
        CustomUser user1 = userService.getUserByLogin(login);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy HH:mm:ss");
        Comment c = new Comment((body == null) ? "" : body, user1.getPathAvatar(), 1, sdf.format(new Date()), user1.getLogin(), id);
        commentService.addComm(c);
        return "redirect:/" + table + "?name=" + name;

    }


    @RequestMapping(value = "/addComment", method = RequestMethod.POST)
    public String addComment(@RequestParam("name") String name, @RequestParam("id") Integer id, @RequestParam String body, @RequestParam String table) {
        String login = null;
        Object sc = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = null;
        if (sc instanceof User) {
            user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            login = user.getUsername();
        }
        if (login == null) return "register";





        CustomUser user1 = userService.getUserByLogin(login);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy HH:mm:ss");

        if (table.equals("Installation")) {
            Comment c = new Comment(body.replaceAll("(\r\n|\n)", "<br />"), user1.getPathAvatar(), 1, sdf.format(new Date()), user1.getLogin(), id);
            commentService.addComm(c);
        } else if (table.equals("Description")) {
            CommentDesc cd = new CommentDesc(body.replaceAll("(\r\n|\n)", "<br />"), user1.getPathAvatar(), 1, sdf.format(new Date()), user1.getLogin(), id);
            commentDescService.addComm(cd);
        } else if (table.equals("Administration")) {
            CommentAdmin cd = new CommentAdmin(body.replaceAll("(\r\n|\n)", "<br />"), user1.getPathAvatar(), 1, sdf.format(new Date()), user1.getLogin(), id);
            commentAdminService.addComm(cd);
        } else if (table.equals("Command")) {
            CommentCommand cd = new CommentCommand(body.replaceAll("(\r\n|\n)", "<br />"), user1.getPathAvatar(), 1, sdf.format(new Date()), user1.getLogin(), id);
            commentCommService.addComm(cd);
        } else if (table.equals("Agent")) {
            CommentAgent cd = new CommentAgent(body.replaceAll("(\r\n|\n)", "<br />"), user1.getPathAvatar(), 1, sdf.format(new Date()), user1.getLogin(), id);
            commentAgentService.addComm(cd);
        } else if (table.equals("AEDB")) {
            CommentAEDB cd = new CommentAEDB(body.replaceAll("(\r\n|\n)", "<br />"), user1.getPathAvatar(), 1, sdf.format(new Date()), user1.getLogin(), id);
            commentAEDBService.addComm(cd);
        } else if (table.equals("WCC")) {
            CommentWCC cd = new CommentWCC(body.replaceAll("(\r\n|\n)", "<br />"), user1.getPathAvatar(), 1, sdf.format(new Date()), user1.getLogin(), id);
            commentWCCService.addComm(cd);
        } else if (table.equals("EEM")) {
            CommentEEM cd = new CommentEEM(body.replaceAll("(\r\n|\n)", "<br />"), user1.getPathAvatar(), 1, sdf.format(new Date()), user1.getLogin(), id);
            commentEEMService.addComm(cd);
        }


        return "redirect:/" + table + "?name=" + name;

    }


    @RequestMapping(value = "/delComment", method = RequestMethod.POST)
    public String delComment(@RequestParam("name") String name, @RequestParam("id") Long id, @RequestParam String table) {
        String login = null;
        Object sc = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = null;
        if (sc instanceof User) {
            user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            login = user.getUsername();
        }
        if (login == null) return "register";

        if (table.equals("Installation")) {
            if (commentService.getCommById(id).getUser().equals(login))
                commentService.deleteOne(id);
            else
                return "redirect:/";
        } else if (table.equals("Description")) {
            if (commentDescService.getCommById(id).getUser().equals(login))
                commentDescService.deleteOne(id);
            else
                return "redirect:/";
        } else if (table.equals("Administration")) {
            if (commentAdminService.getCommById(id).getUser().equals(login))
                commentAdminService.deleteOne(id);
            else
                return "redirect:/";
        } else if (table.equals("Command")) {
            if (commentCommService.getCommById(id).getUser().equals(login))
                commentCommService.deleteOne(id);
            else
                return "redirect:/";
        } else if (table.equals("Agent")) {
            if (commentAgentService.getCommById(id).getUser().equals(login))
                commentAgentService.deleteOne(id);
            else
                return "redirect:/";
        }
        else if (table.equals("AEDB")) {
            if (commentAEDBService.getCommById(id).getUser().equals(login))
                commentAEDBService.deleteOne(id);
            else
                return "redirect:/";
        }
        else if (table.equals("EEM")) {
            if (commentEEMService.getCommById(id).getUser().equals(login))
                commentEEMService.deleteOne(id);
            else
                return "redirect:/";
        }
        else if (table.equals("WCC")) {
            if (commentWCCService.getCommById(id).getUser().equals(login))
                commentWCCService.deleteOne(id);
            else
                return "redirect:/";
        }


        return "redirect:/" + table + "?name=" + name;

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

    private String getLoginName(){
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
