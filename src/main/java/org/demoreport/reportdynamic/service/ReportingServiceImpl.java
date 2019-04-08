package org.demoreport.reportdynamic.service;

import org.demoreport.reportdynamic.model.ReportModel;
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
        return reporting.findById(id);
    }

    @Override
    public void delete(ReportModel id) {
        reporting.delete(id);
    }
}
