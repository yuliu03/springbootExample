package com.scrapy.helloscrapy.service.impl;
import com.common.dao.entity.Test;
import com.common.dao.mapper.TestMapperExt;
import com.scrapy.helloscrapy.common.APIResponse;
import com.scrapy.helloscrapy.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class TestServiceImpl implements TestService {
    @Autowired
    public TestMapperExt testMapperExt;

    public APIResponse deleteByPrimaryKey(Test record) {
        APIResponse apiResponse = new APIResponse();
        return apiResponse;
    }

    public APIResponse insert(Test record) {
        APIResponse apiResponse = new APIResponse();
        return apiResponse;
    }

    public APIResponse selectByPrimaryKey(Test record) {
        APIResponse apiResponse = new APIResponse();
        return apiResponse;
    }

    public APIResponse updateByPrimaryKeySelective(Test record) {
        APIResponse apiResponse = new APIResponse();
        return apiResponse;
    }

    public APIResponse updateByPrimaryKey(Test record) {
        APIResponse apiResponse = new APIResponse();
        return apiResponse;
    }

    public APIResponse selectList(Test record) {
        APIResponse apiResponse = new APIResponse();
        return apiResponse;
    }
}