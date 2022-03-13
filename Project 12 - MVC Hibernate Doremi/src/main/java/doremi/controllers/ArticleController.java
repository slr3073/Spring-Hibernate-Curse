package doremi.controllers;

import doremi.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/articles")
    public String displayArticles(Model model){
        model.addAttribute("articles", articleService.findAllArticles());
        return "articles";
    }

}
