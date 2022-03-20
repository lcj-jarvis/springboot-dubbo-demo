package com.mrlu.dubbo.controller;

import com.mrlu.dubbo.bean.Person;
import com.mrlu.dubbo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 简单de快乐
 * @date 2021-06-23 1:45
 */
@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/person")
    public String getPerson(ModelMap modelMap) {
        modelMap.addAttribute("person", personService.getPerson());
        return "person";
    }
}
