package com.wjyxsy.controller;

import com.wjyxsy.pojo.Article;
import com.wjyxsy.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(value = "/article")
@Controller
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @RequestMapping(value = "/list")
    public String articleList(ModelMap modelMap) {
        List<Article> all = articleRepository.findAll();
        modelMap.addAttribute("articleList", all);
        return "client/index";
    }
}
