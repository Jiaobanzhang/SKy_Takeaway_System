package com.sky.controller.admin;

import com.sky.constant.MessageConstant;
import com.sky.result.Result;
import com.sky.utils.AliOssUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

/**
 * @autor: 我亦无他，唯手熟尔
 * 这个是我们的通用接口
 */

@RestController
@RequestMapping("/admin/common")
@Api(tags = "通用接口")
@Slf4j
public class CommonController {

    @Autowired
    private AliOssUtil aliOssUtil;

    @PostMapping("/upload")
    @ApiOperation("文件上传")
    public Result<String> upload(MultipartFile file) {
        log.info("文件上传：{}", file);

        try {
            //原始文件名，上传的文件的名字
            String originalFilename = file.getOriginalFilename();
            //截取原始文件名的后缀   dfdfdf.png，从最后一个点截取，获取文件名后缀
            String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
            //构造新文件名称 使用 UUID 防止图片命名时重名
            String objectName = UUID.randomUUID().toString() + extension;

            //文件的请求路径,第一个参数是文件对象转换成的数组，第二个参数对应的是传上去的图片在 阿里云上的名字
            String filePath = aliOssUtil.upload(file.getBytes(), objectName);
            return Result.success(filePath);
        } catch (IOException e) {
            log.error("文件上传失败：{}", e);
        }

        return Result.error(MessageConstant.UPLOAD_FAILED);
    }
}
