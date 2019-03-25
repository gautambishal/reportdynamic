package org.demoreport.reportdynamic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name="reports_list")
public class ReportModel {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String reportType;
    private String reportTitle;
}
