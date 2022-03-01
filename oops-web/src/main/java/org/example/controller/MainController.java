package org.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.entity.User;
import org.example.exception.BizErrorCode;
import org.example.exception.BizException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jingwen.li
 * @date 2022/2/28
 */
@Api(value = "测试主类")
@RestController
public class MainController {

    @GetMapping("/hi")
    @ResponseBody
    public List<String> hi(String name) {
        List<String> list = new ArrayList<>();
        list.add(name);
        return list;
    }

    @ApiOperation("用户信息")
    @GetMapping("/user/info")
    @ResponseBody
    public User userInfo(Integer userId, String name) {
        User user = new User();
        if (userId == null){
            throw new BizException(BizErrorCode.UNKNOWN_ERROR);
        }
        user.setId(1);
        user.setName(name);
        user.setAge(19);
        return user;
    }
}
