package com.zj.system.util;

import com.zj.system.entity.ApiEntity;
import com.zj.system.entity.DeviceEntity;
import com.zj.system.model.service.DeviceServise;
import cz.mallat.uasparser.OnlineUpdater;
import cz.mallat.uasparser.UASparser;
import cz.mallat.uasparser.UserAgentInfo;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class UserAgentUtils {
    static UASparser uasParser = null;




    // 初始化uasParser对象
    static {
        try {
            uasParser = new UASparser(OnlineUpdater.getVendoredInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static DeviceEntity UserAgent(String str,ApiEntity apiEntity)
    {
        DeviceEntity deviceEntity = new DeviceEntity();
        DeviceServise deviceServise = new DeviceServise();
        try {
            UserAgentInfo userAgentInfo = UserAgentUtils.uasParser.parse(str);
            deviceEntity.setId("1");
            deviceEntity.setUserAgent(str);
            deviceEntity.setSystem(userAgentInfo.getOsFamily());
            deviceEntity.setBrowser(userAgentInfo.getUaName());
            deviceEntity.setType(userAgentInfo.getType());
            deviceEntity.setCid(apiEntity.getCid());
            deviceEntity.setCip(apiEntity.getCip());
            deviceEntity.setCname(apiEntity.getCname());
           if(str.contains("Android")) {
                deviceEntity.setDevice("Android移动客户端");
            } else if(str.contains("iPhone")) {
                deviceEntity.setDevice("iPhone移动客户端");
            }  else if(str.contains("iPad")) {
                deviceEntity.setDevice("iPad客户端");
            }  else if(str.contains("Windows")){
                deviceEntity.setDevice("Windows客户端");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return deviceEntity;
    }
}
