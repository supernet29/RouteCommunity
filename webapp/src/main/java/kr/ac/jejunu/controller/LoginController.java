package kr.ac.jejunu.controller;

import kr.ac.jejunu.model.User;
import kr.ac.jejunu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by super on 2017-06-09.
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserRepository userRepository;

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showPage(){
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String login(String name, String password, HttpSession httpSession){
        User user = userRepository.findByName(name);
        if(user != null && user.getPassword().equals(password))
            httpSession.setAttribute("user", user);
        return "redirect:/";
    }
}
