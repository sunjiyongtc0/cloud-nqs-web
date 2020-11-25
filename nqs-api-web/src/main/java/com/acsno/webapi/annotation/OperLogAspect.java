package com.acsno.webapi.annotation;


import cn.hutool.json.JSONObject;
import com.acsno.ext.dto.UserDto;
import com.acsno.webapi.service.PdcFeignService;
import com.alibaba.fastjson.JSON;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 切面处理类，操作日志异常日志记录处理
 * */
@Aspect
@Component
public class OperLogAspect{

    @Resource
    private PdcFeignService logFeignService;


    /**
     * 设置操作日志切入点 记录操作日志 在注解的位置切入代码
     */
    @Pointcut("@annotation(com.acsno.webapi.annotation.OperLog)")
    public void pointcut() {}

     /**
      * 正常返回通知，拦截用户操作日志，连接点正常执行完成后执行， 如果连接点抛出异常，则不会执行
      *
      * @param joinPoint 切入点
      * @param keys      返回结果
      */
     @AfterReturning(value = "pointcut()", returning = "keys")
    public void  saveOperLog(JoinPoint joinPoint, Object keys) {
         saveLog(joinPoint);
    }
    @Async
    public void saveLog(JoinPoint joinPoint){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        // 从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) requestAttributes
                .resolveReference(RequestAttributes.REFERENCE_REQUEST);
        JSONObject j=new JSONObject();
        try {
            // 从切面织入点处通过反射机制获取织入点处的方法
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            // 获取切入点所在的方法
            Method method = signature.getMethod();
            // 获取操作
            OperLog opLog = method.getAnnotation(OperLog.class);
            if (opLog != null) {
                j.set("logDesc",opLog.logDesc());// 操作描述
                j.set("logModul",opLog.logModul());// 操作模块
                j.set("logType",opLog.logType());// 操作类型
            }
            String className = joinPoint.getTarget().getClass().getName();      // 获取请求的类名
            String methodName = method.getName();                               // 获取请求的方法名
            methodName = className + "." + methodName;
            j.set("methodName",methodName);// 请求方法
            Map<String, String> rtnMap = converMap(request.getParameterMap());   // 请求的参数
            // 将参数所在的数组转换成json
            String params = JSON.toJSONString(rtnMap);
            UserDto userDto= (UserDto) SecurityUtils.getSubject().getPrincipal();
            j.set("createUser",userDto.getUserName());//操作用户名
            j.set("roleId",userDto.getRoleId());//用户角色Id
            String ip=getIpAddr(request);
            j.set("ips",ip);//用户Ip
            j.set("createTime",System.currentTimeMillis());//操作时间
            logFeignService.saveLogOper(j.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

     /**
      * 转换request 请求参数
      *
      * @param paramMap request获取的参数数组
      */
     public Map<String, String> converMap(Map<String, String[]> paramMap) {
         Map<String, String> rtnMap = new HashMap<String, String>();
         for (String key : paramMap.keySet()) {
             rtnMap.put(key, paramMap.get(key)[0]);
        }
         return rtnMap;
    }


    /**
     * 获取IP地址
     * 使用Nginx等反向代理软件， 则不能通过request.getRemoteAddr()获取IP地址
     * 如果使用了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP地址，X-Forwarded-For中第一个非unknown的有效IP字符串，则为真实IP地址
     */
    public static String getIpAddr(HttpServletRequest request) {

        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;
    }

}
