package com.utn.news.service;

import com.utn.news.exception.ApiError;
import com.utn.news.model.Report;
import com.utn.news.model.TextReport;
import com.utn.news.model.TypeReport;
import com.utn.news.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;


import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReportService {

    private final ReportRepository reportRepository;

    @Autowired
    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }


    public List<Report> getAll() {

        return reportRepository.findAll();
    }

    public void addReport(Report report) {

        reportRepository.save(report);
    }


    public Report getById(Integer id) {

        Optional<Report>report = reportRepository.findById(id);
            if(report.isPresent())
            {
                return report.get();
            }
            else
            {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Report with requested id does not exists");

            }

    }

    public void updateReport(Report report) {

        Integer id = report.getId();
        reportRepository.deleteById(id);
        reportRepository.save(report);
    }

    public void deleteById(Integer id) {

        reportRepository.deleteById(id);
    }

    public List<Report> getTextReports() {

        List<Report>textReports = reportRepository.findAll();
        return  textReports.stream().filter(t->t.typeReport().getDescription().equalsIgnoreCase("text")).collect(Collectors.toList());

    }
}
