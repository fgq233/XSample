package com.example.freemarker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/freemarker")
public class SimpleController {

    @RequestMapping("/if")
    public String tagIf(ModelMap map) { //  if-else
        map.addAttribute("user", "fgq");
        map.addAttribute("num", 666);
        return "if";
    }

    @RequestMapping("/list")
    public String tagList(ModelMap map) { //  list
        List<String> citys = new ArrayList<>();
        citys.add("北京");
        citys.add("上海");
        citys.add("广州");
        citys.add("深圳");
        map.addAttribute("citys", citys);
        return "list";
    }

    @RequestMapping("/date")
    public String dateTest(ModelMap map) { //  日期处理
        map.addAttribute("date", new Date());
        return "date";
    }

    @RequestMapping("/aboutNull")
    public String nullTest(ModelMap map) { //  null值处理
        map.addAttribute("key", null);
        return "aboutNull";
    }

}
