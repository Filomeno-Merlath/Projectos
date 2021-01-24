package com.iade.helloworld.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/java/tester/")
public class JavaTesterController {
    private Logger logger = LoggerFactory.getLogger(JavaTesterController.class);

    /*--- Data types and operators ---*/
        String name = "Filomeno Merlath";
        int number = 20190931;
        float height = 1.73f;
        boolean fanFootball = true;
        String favFootteam = "Benfica";
        char favFolor = 'R';
        
    @GetMapping(path ="/author", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAuthor(){
        logger.info("Welcome to the biogaphy");
        
        String football = (fanFootball ? "" : "not");
        String favTeam = (fanFootball ? "My favorite club is "+favFootteam+".": "");

        return "Done by "+ name +" with number "+ number +".\n"+ "I am "+ height +" tall and "+ football +"a fan of football.\n"+ favTeam
        ;
    }

    /*--- Boolean operations ---*/
    @GetMapping(path ="", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean getGreeting(@PathVariable("student") boolean isStudent, @PathVariable("covid") boolean hasCovid
    ){
        logger.info("Check for access to IADE");

        return isStudent && !hasCovid;
    }

    @GetMapping(path ="/required/{student}/{temperature}/{classType}", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean getRequired(@PathVariable("student") boolean isStudent,
    @PathVariable("temperature") double hasCovid,
    @PathVariable("classType") String type) {
        logger.info("Check if student should be in IADE");

        if(isStudent){
            if(hasCovid < 34.5 || hasCovid > 37.5){
                return false;
            }
            if(!type.equals("digital") && !type.equals("presential") && !type.equals("none")) {
                return false;
            }
            return true;
        }
        return false;
    }

    @GetMapping(path ="", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean getEvacuation(@PathVariable("fire") boolean isfire, 
    @PathVariable("numberOfCovids") int covidnumber,
    @PathVariable("powerShutdown") boolean powerStatus,@PathVariable("comeBackTime") double backTime){

        if(isfire || covidnumber > 5 || (!powerStatus && backTime >15)){
            return true;
        }
        return false;
    }

    /*--- Arrays, Conditionals and Loops ---*/
    private 

}
