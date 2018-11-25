package com.ghostben.wechat.demo.wechat.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: wechat
 * @description: 统一的异常处理类
 * @author: ghostben
 * @create: 2018-11-25 22:48
 * 通常建议写多个异常处理方法，这里处理的是前端的异常，去Catch住我们写的多个异常处理类
 * 直接与前端交互，所以是ControllerAdvice
 *
 **/
@ControllerAdvice
public class AllExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    private Map<String,Object> exceptionHandler(HttpServletRequest request,Exception e){
        Map<String,Object> modelMap = new HashMap<>(16);
        modelMap.put("success",false);
        modelMap.put("errMsg",e.getMessage());
        return modelMap;
    }

}