package kr.ac.jejunu.controller;

import kr.ac.jejunu.model.User;
import kr.ac.jejunu.repository.UserRepository;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * Created by super on 2017-06-09.
 */
@Controller
@RequestMapping("/register")
public class UserRegisterController {
    @Autowired
    private UserRepository repository;

    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showPage(){
       return "register";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String registerUser(@ModelAttribute User user, @RequestParam(name = "image", required = false)MultipartFile file) throws IOException {
        if(file != null && !file.isEmpty()){
            String[] tokens = file.getOriginalFilename().split("\\.");
            String extension = tokens[tokens.length-1];
            String path = saveFile(file, user.getName(), extension);
            user.setImageUrl(path);
        }else{
            user.setImageUrl(null);
        }
        repository.save(user);
        return "redirect:/";
    }

    private String saveFile(MultipartFile file, String name, String extension) throws IOException {
        String path = "/" + name + "." + extension;
        FileOutputStream fileOutputStream = new FileOutputStream(new File("src/main/resources/static/userpicture" + path));
        BufferedOutputStream outputStream = new BufferedOutputStream(fileOutputStream);
        outputStream.write(file.getBytes());
        outputStream.close();
        return path;
    }
}
