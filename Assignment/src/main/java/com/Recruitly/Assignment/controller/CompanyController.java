package com.Recruitly.Assignment.controller;

import com.Recruitly.Assignment.model.Company;
import com.Recruitly.Assignment.service.utility.CompanyUtility;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class CompanyController {
    @Autowired
    private CompanyUtility companyUtility;

    // uri : http://localhost:8080/company/add
    @ApiOperation("This API will create a company document in CompanyDatabase's company collection.")
    @PostMapping("/company/add")
    public String saveCompany(@RequestBody Company company) {
        return companyUtility.saveCompany(company);
    }

    // uri : http://localhost:8080/company/get
    @ApiOperation("This API will fetch all company documents from CompanyDatabase's company collection.")
    @GetMapping({"/company/get", "/index"})
    public List<Company> getCompanies() {
        return companyUtility.getCompanies();
    }

    // uri : http://localhost:8080/company/delete/{id}
    @ApiOperation("This API will delete a company document by id from CompanyDatabase's company collection.")
    @DeleteMapping("/company/delete/{id}")
    public String deleteCompany(@PathVariable int id) throws Exception {
        return companyUtility.deleteCompany(id);
    }

    // uri : http://localhost:8080/company/put/{id}
    @ApiOperation("This API will update a company document by id from CompanyDatabase's company collection.")
    @PutMapping("/company/put/{id}")
    public String updateCompany(@PathVariable int id, @RequestBody Company company) throws Exception {
        return companyUtility.updateCompany(id, company);
    }

}
