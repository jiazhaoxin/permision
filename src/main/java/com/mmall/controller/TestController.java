package com.mmall.controller;

import com.mmall.common.JsonData;
import com.mmall.exception.PermissionExceptin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by admin on 2020/5/18.
 */
@Controller
@RequestMapping("/test/")
@Slf4j
public class TestController {

    @RequestMapping("hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }

    @RequestMapping("test1.json")
    @ResponseBody
    public JsonData test1(){
//        throw  new RuntimeException("test exception");
        return JsonData.success("success");
    }
}
