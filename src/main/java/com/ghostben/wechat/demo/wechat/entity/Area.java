package com.ghostben.wechat.demo.wechat.entity;

import lombok.Data;

import java.util.Date;

/**
 * @program: wechat
 * @description: Area实体类创建
 * @author: ghostben
 * @create: 2018-11-25 16:04
 **/
@Data
public class Area {
    private Integer areaId;
    private String areaName;
    private Integer priority;
    private Date createTime;
    private Date lastEditTime;
}