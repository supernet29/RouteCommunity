package kr.ac.jejunu.controller;

import kr.ac.jejunu.model.Document;
import kr.ac.jejunu.model.User;
import kr.ac.jejunu.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by super on 2017-06-09.
 */
@Controller
@RequestMapping(name = "/")
public class MainController {
    @Autowired
    private DocumentRepository repository;

    public void setRepository(DocumentRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String mainPage(@SessionAttribute(required = false) User user, Model model){
        User userinfo;
        String defaultImage = "/귤.jpeg";
        if(user == null) {
            userinfo = new User("Please Login", null, null, defaultImage);
        }
        else
            userinfo = user;

        if(userinfo.getImageUrl() == null)
            userinfo.setImageUrl(defaultImage);

        List<Document> documents = repository.findAll();
        model.addAttribute("user", userinfo);
        model.addAttribute("documents", documents);
        return "main";
    }
}

