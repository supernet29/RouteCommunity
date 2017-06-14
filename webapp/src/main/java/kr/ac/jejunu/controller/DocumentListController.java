package kr.ac.jejunu.controller;

import kr.ac.jejunu.controller.util.LoginStatusContext;
import kr.ac.jejunu.distance.GpsDistanceCalculator;
import kr.ac.jejunu.model.Document;
import kr.ac.jejunu.model.Position;
import kr.ac.jejunu.model.User;
import kr.ac.jejunu.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by super on 2017-06-09.
 */
@Controller
@RequestMapping(name = "/")
public class DocumentListController {
    @Autowired
    private DocumentRepository repository;

    @Autowired
    private GpsDistanceCalculator gpsDistanceCalculator;

    @Autowired
    private LoginStatusContext loginStatusContext;

    public void setRepository(DocumentRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String allDocuments(@SessionAttribute(required = false) User user, Model model){
        loginStatusContext.setUserInformation(user, model);

        List<Document> documents = repository.findAll();
        model.addAttribute("documents", documents);
        return "main";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String documentsByPosition(@SessionAttribute(required = false) User user,
                                      @RequestParam double source_longitude, @RequestParam double source_latitude,
                                      @RequestParam double destination_longitude, @RequestParam double destination_latitude,
                                      Model model){
        loginStatusContext.setUserInformation(user, model);

        Position searchSourcePosition = new Position(source_latitude, source_longitude);
        Position searchDestinationPosition = new Position(destination_latitude, destination_longitude);

        int allowableDifference = 300;
        List<Document> documents = repository.findAll();
        List<Document> filteredList = filterWithPosition(documents, searchSourcePosition, searchDestinationPosition, allowableDifference);
        model.addAttribute("documents", filteredList);
        return "main";
    }

    private List<Document> filterWithPosition(List<Document> documents, Position searchSourcePosition, Position searchDestinationPosition, int allowableDifference ) {
        List<Document> documentList = new LinkedList<>();
        for(Document document : documents){
            int distanceSource = (int)gpsDistanceCalculator.calculateDistance(searchSourcePosition, document.getSource());
            int distanceDestination = (int)gpsDistanceCalculator.calculateDistance(searchDestinationPosition, document.getDestination());
            if(distanceSource <= allowableDifference && distanceDestination <= allowableDifference){
                documentList.add(document);
            }
        }
        return documentList;
    }
}

