package com.bitcamp.team_project_eco;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@RestController
public class HomeController {
    private static final Logger log = LoggerFactory.getLogger(HomeController.class);
    @GetMapping("/")
    public String home(Locale locale, Model model){
        log.info("HomeController {}.", locale);
        model.addAttribute("serverTime",
                DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale).format(new Date()));
        return "Hello New Project!";
    }
}
