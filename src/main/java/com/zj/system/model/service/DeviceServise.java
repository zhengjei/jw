package com.zj.system.model.service;

import com.zj.system.entity.DeviceEntity;
import com.zj.system.model.mapper.DeviceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("device")
public class DeviceServise {
    @Autowired
    DeviceMapper deviceMapper;
    /**
     * 直接获取所有的数据
     *
     * @return list
     */
    public List<DeviceEntity> selectList(DeviceEntity deviceEntity) {
        return deviceMapper.selectDeviceList(deviceEntity);
    }

    /**
     * 直接获取所有的数据
     * @param ip
     * @return DeviceEntity

    public DeviceEntity selectDeviceEntity(String ip) {
        return deviceMapper.selectDevice(ip);
    }
    */
    /**
     * 插入数据
     * @param deviceEntity
     */
    public Integer insertDeviceEntity(DeviceEntity deviceEntity){
        return deviceMapper.insertDeviceEntity(deviceEntity);
    }




}
