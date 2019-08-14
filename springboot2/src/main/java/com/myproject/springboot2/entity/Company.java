package com.myproject.springboot2.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author
 * @create 2019-07-08-11:01
 */
@Setter
@Getter
@ToString
public class Company {
    private Integer id;
    private String name;
    private String suoxie;
    private Integer provinceid;
    private Integer cityid;
    private Integer areaid;
    private Integer scale;
    private String pickupman;
    private String tel;
    private String smsphone;
    private Long saleman;
    private Integer ckstate;
    private Long accountid;
    private Integer operator;
    private Date createtime;
    private String changeruser;
    private Date changetime;
    private BigDecimal balance;
}