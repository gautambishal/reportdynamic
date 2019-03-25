package org.demoreport.reportdynamic.repository;

import org.demoreport.reportdynamic.model.ReportModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Reporting extends JpaRepository<ReportModel,Integer> {
}
