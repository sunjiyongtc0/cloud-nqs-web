package com.acsno.webapi.annotation;

import java.lang.annotation.*;

/**
  * 自定义操作日志注解
  * @author wu
  */
 @Target(ElementType.METHOD) //注解放置的目标位置,METHOD是可注解在方法级别上
 @Retention(RetentionPolicy.RUNTIME) //注解在哪个阶段执行
 @Documented
public @interface OperLog {
    String logModul() default ""; // 操作模块
    String logType() default "";  // 操作类型
    String logDesc() default "";  // 操作说明
}
