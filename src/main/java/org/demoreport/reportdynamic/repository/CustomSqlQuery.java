package org.demoreport.reportdynamic.repository;

import org.demoreport.reportdynamic.model.ReportData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomSqlQuery {
    @Autowired
    private EntityManager entityManager;


    public List<ReportData> reportDataList(){
       Query query= entityManager.createNativeQuery("select one.ampid as ampid, one.project_title as project_title, dgu.email as creator, one.modified_date as modified_date, one.locationname as locationname, one.actual_start_date as actual_start_date, one.primary_sector as primary_sector, one.budget_code as budget_code, one.commitment as first_commitment, one.disbursement as first_disbursement, two.commitment as second_commitment, two.disbursement as second_disbursement, three.commitment as third_commitment, three.disbursement as third_disbursement, four.commitment as four_commitment, four.disbursement as four_disbursement, five.commitment as five_commitment, five.disbursement as five_disbursement\n" +
               "\n" +
               "from get_data_for_dynamic_reporting('2017-07-16', '2018-07-15', 264) one\n" +
               "\n" +
               "left join get_data_for_dynamic_reporting('2016-07-16', '2017-07-15', 264) two on one.ampid = two.ampid and one.primary_sector = two.primary_sector and one.budget_code = two.budget_code\n" +
               "\n" +
               "left join get_data_for_dynamic_reporting('2015-07-16', '2016-07-15', 264) three on two.ampid = three.ampid and two.primary_sector = three.primary_sector and two.budget_code = three.budget_code\n" +
               "\n" +
               "left join get_data_for_dynamic_reporting('2014-07-16', '2015-07-15', 264) four on three.ampid = four.ampid and three.primary_sector = four.primary_sector and three.budget_code = four.budget_code\n" +
               "\n" +
               "left join get_data_for_dynamic_reporting('2013-07-16', '2014-07-15', 264) five on four.ampid = five.ampid and four.primary_sector = five.primary_sector and four.budget_code = five.budget_code\n" +
               "\n" +
               "inner join dg_user dgu on dgu.id = one.activity_creator order by first_commitment asc",ReportData.class);

       List<ReportData>  reportDataList=query.getResultList();

       for(ReportData reportData: reportDataList){
           if(reportData.getFirst_commitment()==null){
               reportData.setFirst_commitment(0L);
           }
          if(reportData.getSecond_commitment()==null){
               reportData.setSecond_commitment(0L);
           }
          if(reportData.getThird_commitment()==null){
               reportData.setThird_commitment(0L);
           }
          if(reportData.getFour_commitment()==null){
               reportData.setFour_commitment(0L);
           }
          if(reportData.getFive_commitment()==null){
               reportData.setFive_commitment(0L);
           }
          if(reportData.getFirst_disbursement()==null){
               reportData.setFirst_disbursement(0L);
           }
          if(reportData.getSecond_disbursement()==null){
               reportData.setSecond_disbursement(0L);
           }
          if(reportData.getThird_disbursement()==null){
               reportData.setThird_disbursement(0L);
           }
          if(reportData.getFour_disbursement()==null){
               reportData.setFour_disbursement(0L);
           }
          if(reportData.getFive_disbursement()==null){
               reportData.setFive_disbursement(0L);
           }

       }





       return reportDataList;
    }
}
