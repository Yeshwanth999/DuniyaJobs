package com.job_finder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.job_finder.entity.Company;
import com.job_finder.helperClass.CompanyLogin;
import com.job_finder.helperClass.CompanyRegister;
import com.job_finder.response.LoginMessage;
import com.job_finder.service.CompanyService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CompanyController {
    
    @Autowired
    private CompanyService service;

    @PostMapping("/employer-register")
    public Boolean registerCompany(@RequestBody CompanyRegister form) {
      
        return service.addEmployer(form);
    }

    @GetMapping("/show-employers")
    public List<Company> showEmployers() {
        // Assuming you have a method in your service to fetch all employers
        return service.getAllEmployers();
    }

    @PostMapping("/company-login")
    public ResponseEntity<LoginMessage> loginCompany(@RequestBody CompanyLogin companyLogin) {
        LoginMessage loginResponse = service.loginEmployer(companyLogin);
        return new ResponseEntity<>(loginResponse, HttpStatus.OK);
    }

   

   
}