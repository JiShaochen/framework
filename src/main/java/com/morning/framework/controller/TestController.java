package com.morning.framework.controller;

import com.morning.framework.common.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MorningJs
 * @date 2024/6/13 8:43
 * @desc 测试controller
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Value("${demo}")
    private String demo;

    @GetMapping
    public Result test() {
        return Result.success(demo);
    }

}