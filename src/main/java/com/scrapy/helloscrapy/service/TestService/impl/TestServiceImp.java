package com.scrapy.helloscrapy.service.TestService.impl;

import com.common.dao.entity.User;
import com.common.dao.mapper.UserMapper;
import com.scrapy.helloscrapy.service.TestService.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TestServiceImp implements TestService {

    @Resource
    UserMapper userMapper;

    @Override
    public String test() {
        User user=userMapper.selectByPrimaryKey(1);
        return user.toString();
    }
}
