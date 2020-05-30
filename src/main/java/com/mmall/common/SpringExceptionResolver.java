package com.mmall.common;

import com.mmall.exception.ParamException;
import com.mmall.exception.PermissionExceptin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by admin on 2020/5/28.
 * 全局异常处理类
 * 需要正在spring-servlet.xml中配置bean
 */
@Slf4j
public class SpringExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        String url = httpServletRequest.getRequestURI().toString();
        ModelAndView view;
        String defalutMsg = "System error";
        //url结尾是.json的是json数据请求，其他的是页面请求
        if (url.endsWith(".json")){
            //当时自己定义的异常时返回自定义异常消息否则返回默认异常消息
            if (e instanceof PermissionExceptin || e instanceof ParamException){
                JsonData jsonData = JsonData.fail(e.getMessage());
                view = new ModelAndView("jsonView", jsonData.toMap(jsonData));//此jsonView的键与spring-servlet中的jsonView相对应
            }else {
                log.error("unknow json exception url[{}]", url, e);
                JsonData jsonData = JsonData.fail(defalutMsg);
                view = new ModelAndView("jsonView", jsonData.toMap(jsonData));
            }

        }else if (url.endsWith(".page")){
            log.error("unknow page exception url{}", url, e);
            JsonData jsonData = JsonData.fail(defalutMsg);
            view = new ModelAndView("exception", jsonData.toMap(jsonData));
        }else {
            log.error("unknow exception url{}", url, e);
            JsonData jsonData = JsonData.fail(defalutMsg);
            view = new ModelAndView("jsonView", jsonData.toMap(jsonData));
        }
        return view;
    }
}
