package org.demoreport.reportdynamic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping(value="/reports")
    public String report(){
        return "publicreport";
    }
     @RequestMapping(value="/createdwizard")
    public String wizard(){
        return "createwizard";
    }
     @RequestMapping(value="/createdReport")
    public String createdReport(){
        return "createdreport";
    }

}
