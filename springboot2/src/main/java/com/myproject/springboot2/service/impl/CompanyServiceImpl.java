package com.myproject.springboot2.service.impl;

import com.myproject.springboot2.mapper.CompanyMapper;
import com.myproject.springboot2.service.impl.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author
 * @create 2019-07-08-11:02
 */
@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyMapper companyMapper;
    @Override
    public List getAllCompany(){
        return companyMapper.selectAll();
    }


}
