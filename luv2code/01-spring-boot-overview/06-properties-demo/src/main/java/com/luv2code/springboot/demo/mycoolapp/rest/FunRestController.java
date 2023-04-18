package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${coach.name}")
    public String coachName;

    @Value("${team.name}")
    public String teamName;

    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "Coach name: " + coachName + ", Team name: " + teamName;
    }

    @GetMapping("/")
    public String sayHello(){
        return "Hello World!";
    }

    @GetMapping("/workout")
    public String getDailyWotkout(){
        return "Today you rest!";
    }

    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "Today is your lucky day.";
    }

}
