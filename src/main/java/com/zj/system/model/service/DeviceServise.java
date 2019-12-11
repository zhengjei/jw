package com.zj.system.model.service;

import com.zj.system.entity.DeviceEntity;
import com.zj.system.model.mapper.DeviceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
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
    @Transactional(readOnly = false, rollbackFor = SQLException.class)
    public List<DeviceEntity> selectList(DeviceEntity deviceEntity) {
        return deviceMapper.selectDeviceList(deviceEntity);
    }

    /**
     * 直接获取所有的数据
     * @param id
     * @return DeviceEntity
     */
    @Transactional(readOnly = false, rollbackFor = SQLException.class)
    public DeviceEntity selectDeviceEntity(String id) {
        return deviceMapper.selectDevice(id);
    }

    /**
     * 插入数据
     * @param deviceEntity
     */
    @Transactional(readOnly = false, rollbackFor = SQLException.class)
    public Integer insertDeviceEntity(DeviceEntity deviceEntity){
        return deviceMapper.insertDeviceEntity(deviceEntity);
    }




}
