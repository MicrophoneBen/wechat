package com.ghostben.wechat.demo.wechat.service;

import com.ghostben.wechat.demo.wechat.entity.Area;

import java.util.List;

/**
*@author    : Microphoneben
*@date      : 2018/11/25
*@return    :
*@description : AreaService, Service层通常是我们业务逻辑的控制层，这里通常涉及多个数据库，数据表的联调然后数据操作。包括我们的数据处理
*
*/
public interface AreaService {
    List<Area> queryArea();
    Area queryAreaById(int areaId);
    boolean insertArea(Area area);
    boolean updateArea(Area area);
    boolean deleteArea(int areaId);
}
