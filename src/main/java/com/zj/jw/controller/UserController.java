package com.zj.jw.controller;


import com.zj.system.entity.User;
import com.zj.system.model.service.UserServise;
import com.zj.system.util.DeviceUtils;
import nl.bitwalker.useragentutils.Browser;
import nl.bitwalker.useragentutils.OperatingSystem;
import nl.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
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
    private UserServise userServise;

    @Autowired
    HttpServletRequest httpServletRequest;


    @GetMapping("/user")
    @ResponseBody
    public List<User> getUsers(Device device) {
        return userServise.selectList();
    }


    @GetMapping("/device")
    @ResponseBody
    public String userAgent() throws UnknownHostException {
        String ua = httpServletRequest.getHeader("User-Agent");
        boolean device = DeviceUtils.isIOSDevice(httpServletRequest);
        DeviceUtils.isMobileDevice(httpServletRequest);
        DeviceUtils.isWeChat(httpServletRequest);

         //转成UserAgent对象
        UserAgent userAgent = UserAgent.parseUserAgentString(ua);
//获取浏览器信息
        Browser browser = userAgent.getBrowser();
//获取系统信息
        OperatingSystem os = userAgent.getOperatingSystem();
//系统名称
        String system = os.getName();
//浏览器名称
        String browserName = browser.getName();
        System.out.println(system);
        System.out.println(browserName);
        // 获取计算机名
        String name = InetAddress.getLocalHost().getHostName();
        // 获取IP地址
        String ip = InetAddress.getLocalHost().getHostAddress();
        System.out.println("IP地址："+ip);

        return ua;
    }
}
