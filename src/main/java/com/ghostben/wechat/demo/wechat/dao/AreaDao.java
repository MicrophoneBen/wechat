package com.ghostben.wechat.demo.wechat.dao;

import com.ghostben.wechat.demo.wechat.entity.Area;

import java.util.List;

/**
*@author    : Microphoneben
*@date      : 2018/11/25
*@Parameter :  关于Area的CRUD操作
*@description : AreaDao
*/
public interface AreaDao {
    List<Area> queryArea();
    Area queryAreaById(int areaId);
    int insertArea(Area area);
    int updateArea(Area area);
    int deleteArea(int areaId);
}
