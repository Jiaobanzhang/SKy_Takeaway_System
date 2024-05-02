package com.sky.service;

import com.sky.dto.DishDTO;
import org.springframework.stereotype.Service;

/**
 * @autor: 我亦无他，唯手熟尔
 * 新增菜品接口
 */

public interface DishService {
    /**
     * 新增菜品和对应的口味
     * @param dishDTO
     */
    public void saveWithFlavor(DishDTO dishDTO);
}
