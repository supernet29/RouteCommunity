package kr.ac.jejunu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
@RequestMapping(path = "/spring/upload")
public class UploadController {

    @RequestMapping(method = RequestMethod.POST)
    public void upload(@RequestParam("file") MultipartFile file, ModelAndView model) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(new File("src/main/resources/static/" + file.getOriginalFilename()));
        BufferedOutputStream outputStream = new BufferedOutputStream(fileOutputStream);
        outputStream.write(file.getBytes());
        outputStream.close();
        ModelMap modelMap = model.getModelMap();
        modelMap.addAttribute("url", "/" + file.getOriginalFilename());
        model.setViewName("spring/upload");
    }

    @RequestMapping( method=RequestMethod.GET)
    public String upload() {
        return "spring/upload";
    }
}
