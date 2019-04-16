package org.demoreport.reportdynamic.controller;

import org.demoreport.reportdynamic.model.ReportData;
import org.demoreport.reportdynamic.model.ReportModel;
import org.demoreport.reportdynamic.repository.CustomSqlQuery;
import org.demoreport.reportdynamic.service.ReportingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@CrossOrigin
public class IndexController {
    @Autowired
   private  ReportingService reportingService;

    @Autowired
    private CustomSqlQuery customSqlQuery;

    @RequestMapping(value = "/reports")
    public String report(Model model) {

        model.addAttribute("listOfReports", reportingService.listReports());


        return "publicreport";
    }

    @RequestMapping(value = "/createdwizard")
    public String wizard() {
        return "createwizard";
    }

    @RequestMapping(value = "/createdReport")
    public String createdReport() {
        return "createdreport";
    }

    @RequestMapping(value = "/testhtml")
    public String testHtml() {
        return "testhtml";
    }

    @PostMapping("/reportSubmit")
    @ResponseBody
    public String submit(@RequestBody ReportModel reportModel) {
        System.out.println(reportModel);
        reportingService.save(reportModel);
        return "success";
    }

    @GetMapping("/report/{id}")
    public String deleteReport(@PathVariable("id") Integer id){
        ReportModel reportModel=new ReportModel();
        reportModel.setId(id);
        reportingService.delete(reportModel);
        return "redirect:/reports";
    }
//    @GetMapping
//    public String popup() {
//        return "popup";
//    }

    @GetMapping("/specialReport/{id}")
    public String specialReport(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("title", reportingService.findById(id).get());
        model.addAttribute("data",customSqlQuery.reportDataList());
        for(ReportData rd: customSqlQuery.reportDataList()){
            System.out.println(rd);
        }
        return "specialreport";
    }
}
