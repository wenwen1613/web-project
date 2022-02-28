package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 权限认证管理
 * @author jingwen.li
 */
@SpringBootApplication
@EnableDiscoveryClient
public class RabcApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(RabcApplication.class, args);
    }
}
