package org.demoreport.reportdynamic.service;

import org.demoreport.reportdynamic.model.ReportModel;

import java.util.List;
import java.util.Optional;

public interface ReportingService {
    void save(ReportModel reportModel);
    List<ReportModel> listReports();
    Optional<ReportModel> findById(Integer id);
    void delete(ReportModel id);
}
