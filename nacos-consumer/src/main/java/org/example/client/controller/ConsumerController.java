package org.example.client.controller;

import org.example.client.ProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jingwen.li
 * @date 2022/2/22
 */
@RestController
public class ConsumerController {
    @Autowired
    private ProviderClient providerClient;

    @GetMapping("/hi-feign")
    public String hiFeign() {
        return providerClient.hi("feign");
    }
}
