package com.bitcamp.team_project_eco.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/proxy")
public class ProxyController {
    @Autowired Proxy pxy;
    @Autowired Box<Object> box;

}
