package com.sky.controller.admin;

import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @autor: 我亦无他，唯手熟尔
 */
// @RestController 相当于 @Controller + @ResponseBody, @Controller 作用是用于声明 bean 注解,
// @ResponseBody 的作用是将从后端得到的数据转换成 Json 数据, 然后传递给前端
// 注意一点很重要： 这里使用 adminShopController 来命名这个 Controller, 之所以要给他命名，是因为在 user
// 中同时还有一个 ShopController, 为了防止前端在发送请求数据的时候，后端不知道请求的是哪个 Controller, 避免冲突，
// 所以要给不同的 Controller 进行命名
@RestController("adminShopController")
@RequestMapping("/admin/shop")
@Api(tags = "店铺相关接口")
@Slf4j
public class ShopController {
    public static final String KEY = "SHOP_STATUS";

    // 在Config中配置了 RedisConfiguration, 在这个类型中将 Redis 的模版对象设置成了bean 对象,
    // 交给 IOC 容器进行管理, 得到这个 Redis 模版对象就可以用来进行 redis 操作
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 设置店铺的营业状态
     * @param status
     * @return
     */
    @PutMapping("/{status}")
    @ApiOperation("设置店铺的营业状态")
    public Result setStatus(@PathVariable Integer status){
        log.info("设置店铺的营业状态为：{}",status == 1 ? "营业中" : "打烊中");
        redisTemplate.opsForValue().set(KEY,status);
        return Result.success();
    }

    /**
     * 管理端获取店铺的营业状态
     * @return
     */
    @GetMapping("/status")
    @ApiOperation("获取店铺的营业状态")
    public Result<Integer> getStatus(){
        // 通过 redisTemplate 可以操作 redis 来获得所需要的状态数据
        Integer status = (Integer) redisTemplate.opsForValue().get(KEY);
        log.info("获取到店铺的营业状态为：{}",status == 1 ? "营业中" : "打烊中");
        return Result.success(status);
    }

}
