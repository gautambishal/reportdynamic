package org.demoreport.reportdynamic.repository;

import org.demoreport.reportdynamic.model.ReportData;
import org.demoreport.reportdynamic.model.ReportModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Reporting extends JpaRepository<ReportModel,Integer> {


}
