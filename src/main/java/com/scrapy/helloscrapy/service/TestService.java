package com.scrapy.helloscrapy.service;
import com.common.dao.entity.Test;
import com.scrapy.helloscrapy.common.APIResponse;
import java.util.List;

public interface TestService {
    APIResponse deleteByPrimaryKey(Test record);

    APIResponse insert(Test record);

    APIResponse selectByPrimaryKey(Test record);

    APIResponse updateByPrimaryKeySelective(Test record);

    APIResponse updateByPrimaryKey(Test record);

    APIResponse selectList(Test record);
}