package com.sky.annotation;

import com.sky.enumeration.OperationType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @autor: 我亦无他，唯手熟尔
 * 自定义注解，用于标识某个方法需要进行功能字段自动填充处理
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoFill {
    // 数据库操作类型：Update, Insert
    // 这是@AutoFill注解的唯一元素。它表示这个注解需要一个OperationType类型的值。
    // 当你在方法上使用@AutoFill注解时，你需要提供一个OperationType枚举的值
    // 比如说 @AutoFill(value = OperationType.UPDATE)
    OperationType value();
}
