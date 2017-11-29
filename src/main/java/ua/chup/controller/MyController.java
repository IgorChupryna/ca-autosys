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
import ua.chup.model.CustomUser;
import ua.chup.model.Description;
import ua.chup.model.UserRole;
import ua.chup.model.Util;
import ua.chup.service.DescriptionService;
import ua.chup.service.UserService;
import ua.chup.service.UtilService;

import java.util.List;

@Controller
public class MyController {
    static final int DEFAULT_GROUP_ID = -1;
    static final int ITEMS_PER_PAGE = 6;
    @Autowired
    private UserService userService;
    @Autowired
    private UtilService utilService;
    @Autowired
    private DescriptionService descriptionService;

    @RequestMapping("/first")
    public String loginPage(Model model) {

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

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String login = user.getUsername();
        CustomUser dbUser = userService.getUserByLogin(login);
        model.addAttribute("login", login);
        model.addAttribute("roles", user.getAuthorities());
        model.addAttribute("email", dbUser.getEmail());
        model.addAttribute("phone", dbUser.getPhone());


        List<Util> utils = utilService.findAll();
        model.addAttribute("utils", utils);
        return "login";
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
                         Model model) {
        if (userService.existsByLogin(login)) {
            model.addAttribute("exists", true);
            return "register";
        }

        ShaPasswordEncoder encoder = new ShaPasswordEncoder();
        String passHash = encoder.encodePassword(password, null);

        CustomUser dbUser = new CustomUser(login, passHash, UserRole.USER, email, phone);
        userService.addUser(dbUser);

        return "redirect:/";
    }


    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }

    @RequestMapping("/installation")
    public String installation(@RequestParam("name") String name, Model model) {

        return "installation";
    }

    @RequestMapping("/description")
    public String description(@RequestParam("name") String name, Model model) {
        Description desc = descriptionService.getUserByName(name);
        model.addAttribute("desc", desc);
        return "description";
    }

    @RequestMapping("/table")
    public String list(@RequestParam("name") String name, Model model) {
        String shemas ="";
        if (Description.class.getSimpleName().equals(name)) {
            List<Description> list = descriptionService.findAll();
            //Description desc = descriptionService.getUserByName(name);
            //model.addAttribute("desc",desc);
            shemas="description";
            model.addAttribute("list", list);
            model.addAttribute("shemas", shemas);
        }


        return "table";
    }


    @RequestMapping("/unauthorized")
    public String unauthorized(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("login", user.getUsername());
        return "unauthorized";
    }


}
