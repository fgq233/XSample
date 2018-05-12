package com.ehcache.sample.controller;


import com.ehcache.sample.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

    @Autowired
    private CacheService service;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("time", service.getDataFromDb());
        return "/index";
    }

    @RequestMapping("/{param}")
    public String index(@PathVariable("param") Integer param, Model model) {
        model.addAttribute("time", service.getDataFromDb(param));
        return "/index";
    }
}
