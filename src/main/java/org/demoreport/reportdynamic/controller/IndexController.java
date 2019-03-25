package org.demoreport.reportdynamic.controller;

import org.demoreport.reportdynamic.model.ReportModel;
import org.demoreport.reportdynamic.service.ReportingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Optional;

@Controller
public class IndexController {
    @Autowired
    ReportingService reportingService;
    @RequestMapping(value="/reports")
    public String report(Model model){
        model.addAttribute("listOfReports",reportingService.listReports());
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
    public String submit(@RequestBody ReportModel reportModel){
        reportingService.save(reportModel);
        return "success";
    }
    @GetMapping("/specialReport/{id}")
    public String specialReport(@PathVariable("id") Integer id, Model model){


        model.addAttribute("title",reportingService.findById(id).get());
        return "specialreport";
    }
}
