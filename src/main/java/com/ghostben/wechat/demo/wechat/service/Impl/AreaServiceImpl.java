package com.ghostben.wechat.demo.wechat.service.Impl;

import com.ghostben.wechat.demo.wechat.dao.AreaDao;
import com.ghostben.wechat.demo.wechat.entity.Area;
import com.ghostben.wechat.demo.wechat.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @program: wechat
 * @description: Service层的接口实现类
 * @author: ghostben
 * @create: 2018-11-25 22:06
 **/
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> queryArea() {
        return areaDao.queryArea();
    }

    @Override
    public Area queryAreaById(int areaId) {
        return areaDao.queryAreaById(areaId);
    }

    /**
     *@description ： CRUD中涉及到步骤比较复杂的操作，我们就会把这个CRUD过程用事务控制包含起来，
     * 然后进行原子性操作，不是所有的操作，transaction都会进行回滚，默认只是对RunTimeException进行回滚
     * 我们可以使用RollbackFor来指定回滚的Exception级别
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean insertArea(Area area) {
        //进行插入操作时候，AreaName不能为空
        if(area.getAreaName() != null && !"".equals(area.getAreaName())){
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            try {
                int effectedNum = areaDao.insertArea(area);
                if (effectedNum > 0){
                    return true;
                }else {
                    //插入不成功
                    throw new RuntimeException("插入区域信息失败");
                    //通常在我们的系统中，我们不会直接使用Java中的Exception，而是自己定义我们自己的Exception继承JavaRuntimeException
                    //然后写上我们的业务，在Catch的时候直接Catch这个类然后返回友好的错误信息，方便进行错误排查
                }
            } catch (Exception e) {
                throw new RuntimeException("插入区域信息失败" + e.getMessage());
            }
        }else {
          throw new RuntimeException("区域信息不能为空！");
        }
    }

    @Override
    public boolean updateArea(Area area) {
        //进行区域信息更新操作时候，AreaID不能为空
        if(area.getAreaId() != null && area.getAreaId() > 0){
            //设置更新时间默认值
            area.setLastEditTime(new Date());
            try {
                //更新区域信息
                int effectedNum = areaDao.updateArea(area);
                if (effectedNum > 0){
                    return true;
                }else {
                    //更新不成功
                    throw new RuntimeException("更新区域信息失败");
                    //通常在我们的系统中，我们不会直接使用Java中的Exception，而是自己定义我们自己的Exception继承JavaRuntimeException
                    //然后写上我们的业务，在Catch的时候直接Catch这个类然后返回友好的错误信息，方便进行错误排查
                }
            } catch (Exception e) {
                throw new RuntimeException("更新区域信息失败" + e.getMessage());
            }
        }else {
            throw new RuntimeException("区域信息不能为空！");
        }
    }

    @Override
    public boolean deleteArea(int areaId) {
        //进行删除操作时候，AreaName不能为空
        if(areaId > 0){
            //删除操作
            int effectedNum = areaDao.deleteArea(areaId);
            try {
                if (effectedNum > 0){
                    return true;
                }else {
                    //插入不成功
                    throw new RuntimeException("删除区域信息失败");
                    //通常在我们的系统中，我们不会直接使用Java中的Exception，而是自己定义我们自己的Exception继承JavaRuntimeException
                    //然后写上我们的业务，在Catch的时候直接Catch这个类然后返回友好的错误信息，方便进行错误排查
                }
            } catch (Exception e) {
                throw new RuntimeException("删除区域信息失败" + e.toString());
            }
        }else {
            throw new RuntimeException("区域ID不能为空！");
        }
    }
}