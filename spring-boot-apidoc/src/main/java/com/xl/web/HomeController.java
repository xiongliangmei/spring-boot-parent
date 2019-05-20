package com.xl.web;

import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class HomeController {
    public Map<String,Object> greeting(){
        return Collections.singletonMap("message","hello World");
    }
}
