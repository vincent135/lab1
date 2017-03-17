package com.web;

import com.business.Post;
import com.business.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by vincentdemilly on 15/03/2017.
 */
@Controller
public class HelloController {

    @Autowired
    private PublicationService publicationService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String home(Model model) {
        List<Post> posts = publicationService.fetchAll();
        return "hello";
    }

    /*@RequestMapping(value = "/feed", method = RequestMethod.POST)
    public String postt() {
        //spublicationService.post(post);
        return "feed";
    }*/

    @RequestMapping(value = "/share", method = RequestMethod.POST)
    public String share(Post post) {
        publicationService.post(post);
        return "redirect:/feed";
    }

    @RequestMapping(value = "/feed", method = RequestMethod.GET)
    public String fetchPost(Model model) {
        List<Post> posts = publicationService.fetchAll();
        model.addAttribute("posts", posts);
        return "feed";
    }
}
