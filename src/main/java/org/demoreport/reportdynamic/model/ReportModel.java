package org.demoreport.reportdynamic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "reports_list")
public class ReportModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String reportType;
    private String reportTitle;
    private String sqlQuery;
    private String selectedColumns;
    private String selectedMeasures;
    private String reportCategory;
    private String[] headings;
    private String[] footers;


}
