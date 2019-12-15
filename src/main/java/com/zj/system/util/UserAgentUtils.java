package com.zj.system.util;

import com.zj.system.entity.ApiEntity;
import com.zj.system.entity.DeviceEntity;
import cz.mallat.uasparser.OnlineUpdater;
import cz.mallat.uasparser.UASparser;
import cz.mallat.uasparser.UserAgentInfo;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
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
        try {
            UserAgentInfo userAgentInfo = UserAgentUtils.uasParser.parse(str);
            deviceEntity.setId("1");
            deviceEntity.setUserAgent(str);
            deviceEntity.setSystem(userAgentInfo.getOsFamily());
            deviceEntity.setBrowser(userAgentInfo.getUaName());
            deviceEntity.setType(userAgentInfo.getType());
            deviceEntity.setCid(apiEntity.getCid());
            deviceEntity.setCip(apiEntity.getCip());
            deviceEntity.setProvince(apiEntity.getProvince());
            deviceEntity.setCname(apiEntity.getCname());
           if(str.contains("Android")) {
                deviceEntity.setDevice("Android");
            } else if(str.contains("iPhone")) {
                deviceEntity.setDevice("iPhone");
            }  else if(str.contains("iPad")) {
                deviceEntity.setDevice("iPad");
            }  else if(str.contains("Windows")){
                deviceEntity.setDevice("Windows");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return deviceEntity;
    }

    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip.contains(",")) {
            return ip.split(",")[0];
        } else {
            return ip;
        }
    }
}
