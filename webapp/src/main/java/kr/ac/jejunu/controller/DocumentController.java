package kr.ac.jejunu.controller;

import kr.ac.jejunu.model.Comment;
import kr.ac.jejunu.model.Document;
import kr.ac.jejunu.model.Position;
import kr.ac.jejunu.model.User;
import kr.ac.jejunu.repository.CommentRepository;
import kr.ac.jejunu.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by kimwoochan on 2017-06-12.
 */
@Controller
@RequestMapping("/document")
public class DocumentController {
    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private CommentRepository commentRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String writeView(){
        return "documentWrite";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveDocument(@SessionAttribute User user, @ModelAttribute Document document,
                               @RequestParam double source_latitude, @RequestParam double source_longitude,
                               @RequestParam double destination_latitude, @RequestParam double destination_longitude){
        Position source = new Position(source_latitude, source_longitude);
        Position destination = new Position(destination_latitude, destination_longitude);
        document.setWriter(user);
        document.setSource(source);
        document.setDestination(destination);
        documentRepository.save(document);
        return "redirect:/";
    }

    @RequestMapping(value = "/{documentId}", method = RequestMethod.GET)
    public String viewDocument(@PathVariable String documentId, ModelMap model){
        try {
            Long id = Long.parseLong(documentId);
            Document document = documentRepository.findOne(id);
            List<Comment> comments = commentRepository.findByDocument(document);
            model.addAttribute("document", document);
            model.addAttribute("comments", comments);
            return "document";
        } catch (NumberFormatException e) {
            return "redirect:/";
        }
    }


    @RequestMapping(value = "/{documentId}/remove", method = RequestMethod.GET)
    public String removeDocument(@SessionAttribute User user, @PathVariable String documentId){
        Long id = Long.parseLong(documentId);
        Document document = documentRepository.findOne(id);
        if(document.getWriter().equals(user))
            documentRepository.delete(document);

        return "redirect:/";
    }


    @RequestMapping(value = "/{documentId}/comment", method = RequestMethod.POST)
    public String registerComment(@SessionAttribute User user, @PathVariable String documentId ,@RequestParam String comment){
        Long id = Long.parseLong(documentId);
        Document document = documentRepository.findOne(id);
        Comment comment1 = new Comment(document, user, comment);
        commentRepository.save(comment1);
        return "redirect:/document/" + documentId;
    }
}
