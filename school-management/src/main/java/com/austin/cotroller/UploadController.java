package com.austin.cotroller;

import com.austin.pojo.Result;
import com.austin.utils.AliOSSUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class UploadController {
    @Autowired
    private AliOSSUtils aliOSSUtils;

    @RequestMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {
        //调用oss工具类上传图片
        String url=aliOSSUtils.upload(image);
        //返回url给浏览器
        return Result.success(url);
    }

}
