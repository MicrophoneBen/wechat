package com.ghostben.wechat.demo.wechat.dao;

import com.ghostben.wechat.demo.wechat.entity.Area;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {

    @Autowired
    private AreaDao areaDao;

    @Test
    @Ignore
    public void queryArea() {
        List<Area> areaList = areaDao.queryArea();
        assertEquals(2,areaList.size());
    }

    @Test
    public void queryAreaById() {
        Area area = areaDao.queryAreaById(1);
        assertEquals("东园",area.getAreaName());
    }

    @Test
    @Ignore
    public void insertArea() {
        Area area = new Area();
        area.setAreaName("北苑");
        area.setPriority(10);
        int effectNum = areaDao.insertArea(area);
        assertEquals(1,effectNum);
    }

    @Test
    @Ignore
    public void updateArea() {
        Area area = new Area();
        area.setAreaName("东苑");
        area.setPriority(8);
        area.setLastEditTime(new Date());
        assertEquals(1,areaDao.updateArea(area));
    }

    @Test
    @Ignore
    public void deleteArea() {
        assertEquals(1,areaDao.deleteArea(3));
    }
}