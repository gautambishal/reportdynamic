package org.demoreport.reportdynamic.service;

import org.demoreport.reportdynamic.model.ReportData;
import org.demoreport.reportdynamic.model.ReportModel;
import org.demoreport.reportdynamic.repository.CustomSqlQuery;
import org.demoreport.reportdynamic.repository.Reporting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReportingServiceImpl implements ReportingService {
    @Autowired
    private Reporting reporting;
    @Autowired
    private CustomSqlQuery customSqlQuery;

    @Override
    public void save(ReportModel reportModel) {
        reporting.save(reportModel);
    }

    @Override
    public List<ReportModel> listReports() {
        return reporting.findAll();
    }

    @Override
    public Optional<ReportModel> findById(Integer id) {
        Optional<ReportModel> reportModel=reporting.findById(id);

    return reportModel;
    }

    @Override
    public void delete(ReportModel id) {
        reporting.delete(id);
    }

}
