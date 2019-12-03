package com.zj.jw.controller;


import com.zj.system.entity.ApiEntity;
import com.zj.system.entity.DeviceEntity;
import com.zj.system.entity.User;
import com.zj.system.model.service.DeviceServise;
import com.zj.system.model.service.UserServise;
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
import java.util.List;
/**
 * @author: Matthew
 * @Date: 2019/3/14 17:00
 * @Description:
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private UserServise userServise;

    @Autowired
    private DeviceServise deviceServise;

    @Autowired
    HttpServletRequest httpServletRequest;

    @GetMapping("/user")
    @ResponseBody
    public List<User> getUsers() {
        return userServise.selectList();
    }

    @GetMapping("/device")
    @ResponseBody
    public List<DeviceEntity> userAgent() {
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
        DeviceEntity deviceEntity = UserAgentUtils.UserAgent(ua,apiEntity);
        deviceServise.insertDeviceEntity(deviceEntity);
        List<DeviceEntity> deviceEntityList = deviceServise.selectList(deviceEntity1);
        return deviceEntityList;
    }


}
