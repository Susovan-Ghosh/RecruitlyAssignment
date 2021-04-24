package com.Recruitly.Assignment.controller;

import com.Recruitly.Assignment.model.Company;
import com.Recruitly.Assignment.service.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {
    @Autowired
    private CompanyRepository companyRepository;

    @PostMapping("/company/add")
    public String saveCompany(@RequestBody Company company) {
        companyRepository.save(company);
        return "Company (id = " + company.getId() + ") added.";
    }

    @GetMapping("/company/get")
    public List<Company> getCompanies() {
        return companyRepository.findAll();
    }

    @DeleteMapping("/company/delete/{id}")
    public String deleteCompany(@PathVariable int id) throws Exception {
        Company isCompanyPresent = companyRepository.findById(id)
                .orElseThrow(() -> new Exception("Company (id = " + id + ") not found!"));
        companyRepository.deleteById(id);
        return "Company (id = " + id + ") deleted.";
    }

    @PutMapping("/company/put/{id}")
    public String updateCompany(@PathVariable int id, @RequestBody Company company) throws Exception {
        Company isCompanyPresent = companyRepository.findById(id)
                .orElseThrow(() -> new Exception("Company (id = " + id + ") not found!"));
        company.setId(id);
        companyRepository.save(company);
        return "Company (id = " + id + ") update.";
    }

}
