package org.demoreport.reportdynamic.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class ReportData {
    @Id
    private String ampid;
    private String project_title;
    private String creator;
    private String modified_date;
    private String locationname;
    private String actual_start_date;
    private String primary_sector;
    private String budget_code;
    private String commitment;
    private String disbursement;
}
