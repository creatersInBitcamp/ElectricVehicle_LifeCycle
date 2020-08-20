package com.bitcamp.team_project_eco.utils;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/proxy")
public class ProxyController {
    private final Proxy pxy;
    private final Box<Object> box;

    public ProxyController(Proxy pxy, Box<Object> box) {
        this.pxy = pxy;
        this.box = box;
    }
}
