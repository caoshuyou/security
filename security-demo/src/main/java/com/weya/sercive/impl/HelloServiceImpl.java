package com.weya.sercive.impl;

import com.weya.sercive.HelloService;

public class HelloServiceImpl implements HelloService {
    @Override
    public String greeting(String name) {
        System.out.println("greeting");
        return "hello "+name;
    }
}
