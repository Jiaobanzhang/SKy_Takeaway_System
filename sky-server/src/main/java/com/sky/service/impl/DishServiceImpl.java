package com.sky.service.impl;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.sky.dto.DishDTO;
import com.sky.entity.Dish;
import com.sky.entity.DishFlavor;
import com.sky.mapper.DishFlavorMapper;
import com.sky.mapper.DishMapper;
import com.sky.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @autor: 我亦无他，唯手熟尔
 */
@Service
@Slf4j
public class DishServiceImpl implements DishService {

    @Autowired
    private DishMapper dishMapper;

    @Autowired
    private DishFlavorMapper dishFlavorMapper;

    /**
     * 新增菜品和对应的口味
     *
     * @param dishDTO
     */
    @Transactional
    @Override
    public void saveWithFlavor(DishDTO dishDTO) {

        // 对 Dish 表进行数据存入
        // 由于前端传递过来的数据 dishDTO 中包含了 Dish 表的数据和 flavor 表的数据
        // 所以说这里想要把数据存到 Dish 数据库的我话，得先把 Dish 数据提取出来
        Dish dish = new Dish();
        BeanUtils.copyProperties(dishDTO, dish);
        // 插入 Dish 数据
        dishMapper.insert(dish);

        // 对 flavor 数据进行存入：
        //获取insert语句生成的主键值
        Long dishId = dish.getId();

        List<DishFlavor> flavors = dishDTO.getFlavors();
        if (flavors != null && flavors.size() > 0) {
            flavors.forEach(dishFlavor -> {
                dishFlavor.setDishId(dishId);
            });
            //向口味表插入n条数据
            dishFlavorMapper.insertBatch(flavors);//后绪步骤实现
        }

    }
}
