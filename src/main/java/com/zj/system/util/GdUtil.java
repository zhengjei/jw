package com.zj.system.util;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.zj.system.entity.ApiEntity;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

public class GdUtil {
    private static final String KEY = "9bf4b0025e4f3e73950dbe7d9bfccca5";       //web服务的key

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    private static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = JSONObject.parseObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    public static ApiEntity getCityCodeByIp(String ipAddress) {
        JSONObject json = null;
        ApiEntity apiEntity = new ApiEntity();
        try {
            json = readJsonFromUrl("http://restapi.amap.com/v3/ip?ip=" + ipAddress + "&key=" + KEY + "");
        } catch (IOException e) {
            e.printStackTrace();
        }
        apiEntity.setProvince(json.getString("province"));
        apiEntity.setCname(json.getString("city"));
        apiEntity.setCid(json.getString("adcode"));
        return apiEntity;
    }
}
