package org.example;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 * @author jingwen.li
 */
@SpringBootApplication
@EnableDiscoveryClient
public class RbacApplication
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
