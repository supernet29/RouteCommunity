package kr.ac.jejunu.controller.util;

import kr.ac.jejunu.model.User;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

/**
 * Created by super on 2017-06-14.
 */
@Component
public class LoginStatusContext {
    public void setUserInformation(User user, Model model) {
        User userinfo;
        String defaultImage = "/귤.jpeg";
        String accountUrl;
        String accountText;
        if(user == null) {
            userinfo = new User("Please Login", null, null, defaultImage);
            accountText="Login";
            accountUrl="/login";
        }
        else {
            userinfo = user;
            accountText="Logout";
            accountUrl="/logout";
        }

        if(userinfo.getImageUrl() == null)
            userinfo.setImageUrl(defaultImage);

        model.addAttribute("user", userinfo);
        model.addAttribute("accountUrl", accountUrl);
        model.addAttribute("accountText", accountText);
    }
}
