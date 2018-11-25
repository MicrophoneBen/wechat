package com.ghostben.wechat.demo.wechat.controller;

import com.ghostben.wechat.demo.wechat.entity.Area;
import com.ghostben.wechat.demo.wechat.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: wechat
 * @description: Web层的Controller层
 * @author: ghostben
 * @create: 2018-11-25 22:34
 **/
@RestController
public class AreaController {

    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/listarea", method = RequestMethod.GET)
    private Map<String,Object> listArea(){
        Map<String,Object> modelMap = new HashMap<>(16);
        List<Area> areaList = areaService.queryArea();
        modelMap.put("areaList",areaList);
        return modelMap;
    }

    @RequestMapping(value = "/getareabyid", method = RequestMethod.GET)
    private Map<String, Object> getAreaById(Integer areaId){
        Map<String,Object> modelMap = new HashMap<>(16);
        Area area = areaService.queryAreaById(areaId);
        modelMap.put("area",area);
        return modelMap;
    }

    @RequestMapping(value = "/addarea", method = RequestMethod.POST)
    private Map<String,Object> addArea(@RequestBody Area area){
        Map<String,Object> modelMap = new HashMap<>(16);
        modelMap.put("success",areaService.insertArea(area));
        return modelMap;
    }

    @RequestMapping(value = "/modifyarea", method = RequestMethod.POST)
    private Map<String,Object> modifyArea(@RequestBody Area area){
        Map<String,Object> modelMap = new HashMap<>(16);
        //修改区域信息
        modelMap.put("success",areaService.updateArea(area));
        return modelMap;
    }

    @RequestMapping(value = "/removearea", method = RequestMethod.GET)
    private Map<String, Object> removeArea(Integer areaId){
        Map<String,Object> modelMap = new HashMap<>(16);
        modelMap.put("success",areaService.deleteArea(areaId));
        return modelMap;
    }

}