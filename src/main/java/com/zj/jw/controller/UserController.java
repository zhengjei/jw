package com.zj.jw.controller;


import com.zj.jw.common.domain.TableDataInfo;
import com.zj.system.entity.ApiEntity;
import com.zj.system.entity.DeviceEntity;
import com.zj.system.entity.User;
import com.zj.system.entity.VisitEntity;
import com.zj.system.model.service.DeviceServise;
import com.zj.system.model.service.UserServise;
import com.zj.system.model.service.VisitServise;
import com.zj.system.util.IdUtil;
import com.zj.system.util.UserAgentUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
public class UserController extends BaseController  {
    private String prefix = "table";

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private UserServise userServise;

    @Autowired
    private DeviceServise deviceServise;

    @Autowired
    private VisitServise visitServise;

    @Autowired
    HttpServletRequest httpServletRequest;

    @GetMapping("/user")
    @ResponseBody
    public List<User> getUsers() {
        return userServise.selectList();
    }

    @GetMapping("/device")
    //@RequestMapping("/device")
    //@ResponseBody
    public String userAgent(ModelMap map) {

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
        visitServise.updateTest(deviceEntity.getDevice());
        String id = IdUtil.uuid();
        deviceEntity.setId(id);
        deviceServise.insertDeviceEntity(deviceEntity);
        DeviceEntity deviceEntity1 = deviceServise.selectDeviceEntity(id);
        map.addAttribute("deviceEntity",deviceEntity1);


        return prefix + "/table";
    }
    @GetMapping("/a")
    //@RequestMapping("/device")
    //@ResponseBody
    public String a() {
        return prefix + "/a";
    }
    @RequestMapping("/deviceList")
    @ResponseBody
    public TableDataInfo searchList(DeviceEntity deviceEntity) {
        startPage();
        List<DeviceEntity> deviceEntityList = deviceServise.selectList(deviceEntity);
        return getDataTable(deviceEntityList);
    }

    @RequestMapping("/visitList")
    @ResponseBody
    public List<VisitEntity> visitList(VisitEntity visitEntity) {
        //VisitEntity visitEntity = new VisitEntity();
        List<VisitEntity> list = visitServise.selectVisitEntityList(visitEntity);
        return list;
    }
}
