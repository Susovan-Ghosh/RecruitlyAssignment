package com.Recruitly.Assignment.service.utility;

import com.Recruitly.Assignment.model.Company;
import com.Recruitly.Assignment.service.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompanyUtility {
    @Autowired
    private CompanyRepository companyRepository;

    public String saveCompany(Company company) {
        companyRepository.save(company);
        return "Company (id = " + company.getId() + ") added.";
    }

    public List<Company> getCompanies() {
        return companyRepository.findAll();
    }

    public String deleteCompany(int id) throws Exception {
        Company isCompanyPresent = companyRepository.findById(id)
                .orElseThrow(() -> new Exception("Company (id = " + id + ") not found!"));
        companyRepository.deleteById(id);
        return "Company (id = " + id + ") deleted.";
    }

    public String updateCompany(int id, Company company) throws Exception {
        Company isCompanyPresent = companyRepository.findById(id)
                .orElseThrow(() -> new Exception("Company (id = " + id + ") not found!"));
        company.setId(id);
        companyRepository.save(company);
        return "Company (id = " + id + ") update.";
    }
}
