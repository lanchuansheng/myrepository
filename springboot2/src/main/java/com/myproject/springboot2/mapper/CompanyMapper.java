package com.myproject.springboot2.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author
 * @create 2019-07-08-11:01
 */
@Mapper
@Component
public interface CompanyMapper {
    List selectAll();
}
