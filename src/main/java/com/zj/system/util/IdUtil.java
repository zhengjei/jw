package com.zj.system.util;

import com.alibaba.druid.util.Base64;
import com.zj.jw.common.constant.SysConstant;
import java.security.SecureRandom;
import java.util.UUID;

public class IdUtil {

    public static String uuid() {
        return UUID.randomUUID().toString();
    }

    public static String iGId(){
        return String.valueOf(org.jasypt.contrib.org.apache.commons.codec_1_3.binary.Base64.encodeBase64(Long.toBinaryString(System.currentTimeMillis()).getBytes()));
    }

    public static String igId(){
        return String.valueOf(Base64.base64ToByteArray(Long.toBinaryString(System.currentTimeMillis())));
    }

    public static String randomId(){
        SecureRandom secureRandom = new SecureRandom();
        return secureRandom.generateSeed(128).toString();
    }

    public static String IGenId(){
        IdCommon idCommon = new IdCommon(SysConstant.WORK_ID, SysConstant.DATA_CENTER_ID);
        //避免事件冲突
        try {
            Thread.sleep(Thread.MIN_PRIORITY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return String.valueOf(idCommon.nextId());
    }

}
