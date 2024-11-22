package com.austin.service.impl;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "aliyun.oss")
public class AliOSSProperties {
    //����
    private String endpoint;
    //���id
    private String accessKeyId;
    //��Կ
    private String accessKeySecret;
    //�洢�ռ�
    private String bucketName;
}
