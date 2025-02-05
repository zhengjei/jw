package com.zj.jw.controller;

import com.zj.system.entity.ApiEntity;
import com.zj.system.entity.DeviceEntity;
import com.zj.system.model.service.DeviceServise;
import com.zj.system.util.UserAgentUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 郑杰
 * @date 2019/11/17 12:40
 */
@Controller
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private DeviceServise deviceServise;

    @Autowired
    HttpServletRequest httpServletRequest;

    @GetMapping("/device")
    @ResponseBody
    public String userAgent() {
        DeviceEntity deviceEntity = new DeviceEntity();
        DeviceEntity deviceEntity1 = new DeviceEntity();
        String ua = httpServletRequest.getHeader("User-Agent");
        String url="http://pv.sohu.com/cityjson";
        ResponseEntity<String> results = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        String jsonStr = results.getBody();
        assert jsonStr != null;
        String str2 = jsonStr.substring(19);
        str2 = str2.substring(0,str2.length() - 1);
        JSONObject jsonobject = JSONObject.fromObject(str2);
        ApiEntity apiEntity= (ApiEntity)JSONObject.toBean(jsonobject,ApiEntity.class);
        deviceEntity = UserAgentUtils.UserAgent(ua,apiEntity);
        deviceServise.insertDeviceEntity(deviceEntity);
        return ua;
    }


}
