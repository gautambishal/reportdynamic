package org.demoreport.reportdynamic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

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

    @RequestMapping(value="/testhtml")
    public String testHtml(){
        return "testhtml";
    }

    @PostMapping("/reportSubmit")
    @ResponseBody
    public String submit(HttpServletRequest servletRequest){
        Map<String,String> fields=servletRequest.getTrailerFields();
        for(Map.Entry m: fields.entrySet()){
            System.out.println(m.getKey()+ " "+m.getValue());

        }
        return "Saved Successfully";
    }
}
