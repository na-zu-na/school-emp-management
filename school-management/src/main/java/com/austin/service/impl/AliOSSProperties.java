package com.austin.service.impl;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "aliyun.oss")
public class AliOSSProperties {
    //区域
    private String endpoint;
    //身份id
    private String accessKeyId;
    //密钥
    private String accessKeySecret;
    //存储空间
    private String bucketName;
}
