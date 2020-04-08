package com.scrapy.service;
import com.common.dao.entity.Test;
import com.scrapy.common.APIResponse;

public interface TestService {
    APIResponse deleteByPrimaryKey(Test record);

    APIResponse insert(Test record);

    APIResponse selectByPrimaryKey(Test record);

    APIResponse updateByPrimaryKeySelective(Test record);

    APIResponse updateByPrimaryKey(Test record);

    APIResponse selectList(Test record);
}