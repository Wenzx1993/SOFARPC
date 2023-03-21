package com.example.sofarpcconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("test")
@RestController
public class HelloReferenceController {

    @Autowired
    private HelloReferenceService helloReferenceService;

    @RequestMapping("hello")
    void hello(){
        helloReferenceService.hello();
    }
}
