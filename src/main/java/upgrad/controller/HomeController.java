package upgrad.controller;

import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import upgrad.model.Post;
import upgrad.service.PostService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private PostService postService;

    @RequestMapping("/")
    public String getAllPosts(Model model) {

        List<Post> Posts = postService.getAllPosts();

        model.addAttribute("Posts",Posts);

        return "Index";

    }
}
