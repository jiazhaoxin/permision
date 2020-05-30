package com.mmall.common;

import com.google.common.collect.Maps;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2020/5/28.
 * 返回数据类
 */
@Setter
@Getter
public class JsonData {

    private boolean ret;

    private String msg;

    private Object data;

    public JsonData(boolean ret){
        this.ret = ret;
    }

    public static JsonData success(Object object, String msg){
        JsonData jsonData = new JsonData(true);
        jsonData.msg = msg;
        jsonData.data = object;
        return jsonData;
    }

    public static JsonData success(Object object){
        JsonData jsonData = new JsonData(true);
        jsonData.data = object;
        return jsonData;
    }

    public static JsonData success(){
        JsonData jsonData = new JsonData(true);
        return jsonData;
    }

    public static JsonData fail(String msg){
        JsonData jsonData = new JsonData(false);
        jsonData.msg = msg;
        return jsonData;
    }

    public Map<String, Object> toMap(JsonData jsonData){
        HashMap<String, Object> map = Maps.newHashMap();
        map.put("ret", jsonData.ret);
        map.put("msg", jsonData.msg);
        map.put("data", jsonData.data);
        return map;
    }
}
