package com.utn.news.controller;

import com.utn.news.model.Report;
import com.utn.news.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportController {

    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/")
    public List<Report> getAll()
    {
        return reportService.getAll();
    }

    @PostMapping()
    public void addReport(@RequestBody Report report)
    {
        reportService.addReport(report);
    }

    @GetMapping("/{id}")
    public Report getById(@PathVariable Integer id)
    {
        return reportService.getById(id);
    }

    @PostMapping("/updateReport")
    public void updateReport(@RequestBody Report report)
    {
        reportService.updateReport(report);
    }
    @PostMapping("/{id}")
    public void deleteById(@PathVariable Integer id)
    {
        reportService.deleteById(id);
    }

    @GetMapping("/textReports")
    public List<Report>getTextReports()
    {
        return reportService.getTextReports();
    }
}
