package com.offcn.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class OSSTest {

    /**
     * OSS 使用步骤 阿里云
     * 1）、引入SDK
     * 2）、配置好相应的属性
     */
    public static void main(String[] args)throws IOException {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-beijing.aliyuncs.com";
        // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
        String accessKeyId = "LTAI4FzHLVqHtoZEfqgNYGw3";
        String accessKeySecret = "KYhDJWgFw1jZ4h2ZsBVquIL7omV3Vr";
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        // 更换一张图片上传。
        InputStream inputStream = new FileInputStream(new File("/Users/travelround/Pictures/素材/c.png"));
        // Bucket名不变,Bucket中创建的文件夹名,更改存储后的文件名
        // atcrowdfunding@1619955329481858.onaliyun.com
        ossClient.putObject("zhouyou-bucket", "pic/2.png", inputStream);
        // 关闭OSSClient。
        ossClient.shutdown();

        System.out.println("测试完成");
    }
}
