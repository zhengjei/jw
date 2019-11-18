package com.zj.jw.controller;

import com.zj.system.model.service.DeviceServise;
import com.zj.system.util.DeviceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 郑杰
 * @date 2019/11/17 12:40
 */
@Controller
@RequestMapping("/device")
public class DeviceController {
    @Autowired
    private DeviceServise deviceServise;

    @Autowired
    HttpServletRequest httpServletRequest;

    @GetMapping("/device")
    @ResponseBody
    public String userAgent() {
        String ua = httpServletRequest.getHeader("User-Agent");
        boolean device = DeviceUtils.isIOSDevice(httpServletRequest);
        DeviceUtils.isMobileDevice(httpServletRequest);
        DeviceUtils.isWeChat(httpServletRequest);
        return ua;
    }


}
