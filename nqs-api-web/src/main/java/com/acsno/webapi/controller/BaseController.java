package com.acsno.webapi.controller;

import com.acsno.ext.kit.Ret;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class BaseController {
    /**
     *  全局权限异常处理
     *  如果不是Ajax请求返回500页面
     *  如果是则{"msg":"无效的访问权限！","state":"fail"}
     */
    @ExceptionHandler({ UnauthorizedException.class, AuthorizationException.class })
    public ModelAndView authorizationException(HttpServletRequest request, HttpServletResponse response) {
        if (isAjaxRequest(request)) {
            ModelAndView mav=new ModelAndView(new MappingJackson2JsonView());
            mav.addAllObjects(Ret.fail("msg","无效的访问权限！"));
            return mav;
        } else {
            ModelAndView mav = new ModelAndView("/error/500");
            return mav;
        }
    }



    /**
     * 是否是Ajax请求
     *
     */
    public static boolean isAjaxRequest(HttpServletRequest request) {
        String requestType = request.getHeader("X-Requested-With");
        if ("XMLHttpRequest".equals(requestType)) {
            return true;
        } else {
            return false;
        }
    }
}
