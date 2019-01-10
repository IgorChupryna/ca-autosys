package ua.chup.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.chup.model.*;
import ua.chup.service.*;

import java.text.SimpleDateFormat;
import java.util.Date;



@Controller
public class CommentController {
    @Autowired
    private UserService userService;
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
    private CommentDescService commentDescService;
    @Autowired
    private CommentService commentService;



    @RequestMapping(value = "/adddComment")
    public String adddComment(@RequestParam("name") String name, @RequestParam("id") Integer id, @RequestParam(required = false) String body, @RequestParam String table) {
        String login = null;
        Object sc = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user;
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
        User user;
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
        User user;
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

}
