package kr.ac.jejunu.controller;

import kr.ac.jejunu.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;

/**
 * Created by kimwoochan on 2017-06-12.
 */
@Controller
@RequestMapping("/logout")
public class LogoutController {
    @RequestMapping(method = RequestMethod.GET)
    public String logout(@SessionAttribute(required = false) User user, HttpSession session){
        if(user != null) session.removeAttribute("user");
        return "redirect:/";
    }
}
