package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @autor: 我亦无他，唯手熟尔
 * 处理新增菜品口味的接口
 */

@Mapper
public interface DishFlavorMapper {

    /**
     * 用于插入口味数据
     * @param flavors
     */
    void insertBatch(List<DishFlavor> flavors);
}
