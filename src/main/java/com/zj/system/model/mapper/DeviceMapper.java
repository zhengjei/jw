package com.zj.system.model.mapper;

import com.zj.system.entity.DeviceEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 设备信息mapper
 * @author 郑杰
 * @date : 2019/11/13 9:44
 */
@Component
@Mapper
public interface DeviceMapper {
    /**
     * 直接获取所有的有效数据
     * @return list
     */
    List<DeviceEntity> selectDeviceList(DeviceEntity deviceEntity);

    /**
     * 直接获取所有的有效数据
     * @return DeviceEntity
     */
    DeviceEntity selectDevice(String id);

    /**
     * huanq
     * @return DeviceEntity
    DeviceEntity selectDevice(String ip);
     */

    /**
     *插入已修课程信息
     *@param deviceEntity 实体
     * @return Integer
     */
    Integer insertDeviceEntity(DeviceEntity deviceEntity);
}
