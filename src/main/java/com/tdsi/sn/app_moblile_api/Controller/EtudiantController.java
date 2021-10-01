package com.tdsi.sn.app_moblile_api.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EtudiantController {

    @GetMapping("/")
    public String hello(){
        return "Hello World" ;
    }
}
