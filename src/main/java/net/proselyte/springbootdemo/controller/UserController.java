package net.proselyte.springbootdemo.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import net.proselyte.springbootdemo.model.User;
import net.proselyte.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.script.ScriptContext;
import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    private List<Map<String, String>> messages = new ArrayList<Map<String, String>>() {{
        add(new HashMap<String, String>() {{ put("id", "1"); put("text", "First message"); }});
        add(new HashMap<String, String>() {{ put("id", "2"); put("text", "Second message"); }});
        add(new HashMap<String, String>() {{ put("id", "3"); put("text", "Third message"); }});
    }};
    private UserService userService;

    public static int idd;

    @Autowired
    public  UserController(UserService userService){

        this.userService = userService;
    }


    @GetMapping("/users")
    public  String findAll(Model model) {

        List<User> users = userService.findAll();
        model.addAttribute("users", users);

        return "userList";
    }

    @GetMapping("/userCrt")
    public String createUserForm(User user){
        return "userCrt";
    }

    @PostMapping("/userCrt")
    public String createUser(User user, HttpServletResponse response){
        userService.saveUser(user);
        idd = Math.toIntExact(user.getId());
        response.addCookie(new Cookie("id", Integer.toString(idd)));
        return "redirect:/users";
    }

    @GetMapping("/userDel/{Id}")
    public String delectUser(@PathVariable("Id") Long Id){
        userService.deleteById(Id);

        return "redirect:/users";
    }

    @GetMapping("/userUpd/{Id}")
    public String updUserForm(@PathVariable("Id") Long Id, Model model){
        User user = userService.findById(Id);
        model.addAttribute("user", user);
        return "/userUpd";
    }

    @PostMapping("/userUpd")
    public String updUser(User user){
        userService.saveUser(user);
        return "redirect:/users";
    }
}
