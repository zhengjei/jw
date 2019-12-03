package com.zj.jw.controller;

import com.zj.system.entity.ApiEntity;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
/**
 * 控制器
 * @author 郑杰
 * @date 2019/11/27 2:18
 */
@Controller
@RequestMapping("/api")
public class ApiController {
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/GetApi")
    @ResponseBody
    public String getJson(){
        String url="http://pv.sohu.com/cityjson";
        ResponseEntity<String> results = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        String jsonStr = results.getBody();
        String str2 = jsonStr.substring(19);
        str2 = str2.substring(0,str2.length() - 1);
        JSONObject jsonobject = JSONObject.fromObject(str2);
        ApiEntity apiEntity= (ApiEntity)JSONObject.toBean(jsonobject,ApiEntity.class);
        System.out.println(apiEntity);
        return str2;
    }
}
