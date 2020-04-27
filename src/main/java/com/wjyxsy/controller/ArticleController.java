package com.wjyxsy.controller;

import com.wjyxsy.pojo.Article;
import com.wjyxsy.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(value = "/article")
@Controller
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @RequestMapping(value = "/list")
    public String articleList(ModelMap modelMap, Integer pageNum) {
        if (pageNum == null){
            pageNum = 1;
        }
        Pageable pageable = PageRequest.of(pageNum-1, 2);
        Page<Article> all = articleRepository.findAll(pageable);

        modelMap.addAttribute("pageInfo", all);
        return "client/index";
    }
}
