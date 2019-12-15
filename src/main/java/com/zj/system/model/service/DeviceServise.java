package com.zj.system.model.service;

import com.zj.system.entity.DeviceEntity;
import com.zj.system.model.mapper.DeviceMapper;
import com.zj.system.util.AddressUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
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
        System.out.println(deviceEntity.getProvince());
        return deviceMapper.insertDeviceEntity(deviceEntity);
    }

    // 测试
    public void ipdiz() throws JSONException {
        AddressUtils addressUtils = new AddressUtils();
        String ip = "61.146.63.53";
        String address = "";
        try {
            address = addressUtils.getAddresses("ip=" + ip, "utf-8");
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = new JSONObject(address);
        jsonObject = jsonObject.getJSONObject("data");
        //通过相应的get方法,获取相应的属性
        String county = jsonObject.getString("country_id");//国家
        String region = jsonObject.getString("region");//省份
        String city = jsonObject.getString("city");//城市
        String telecom = jsonObject.getString("isp");//运营商
        System.out.println("获取的地址为：" + address);
        System.out.println("解析得到的地址为：" +county+","+ region + "省;" + city + "市,"+telecom);
    }



}
