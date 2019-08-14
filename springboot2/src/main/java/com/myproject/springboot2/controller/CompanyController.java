package com.myproject.springboot2.controller;

import com.myproject.springboot2.service.impl.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author
 * @create 2019-07-08-11:03
 */
@RestController
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @RequestMapping("/getall")
    @ResponseBody
    public List getAll(){
        return companyService.getAllCompany();
    }
}
