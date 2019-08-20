package com.scrapy.helloscrapy.service.impl;
import com.common.dao.entity.RoleUser;
import com.common.dao.mapper.RoleUserMapperExt;
import com.scrapy.helloscrapy.common.APIResponse;
import com.scrapy.helloscrapy.service.RoleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class RoleUserServiceImpl implements RoleUserService {
    @Autowired
    public RoleUserMapperExt roleUserMapperExt;

    public APIResponse deleteByPrimaryKey(RoleUser record) {
        APIResponse apiResponse = new APIResponse();
        return apiResponse;
    }

    public APIResponse insert(RoleUser record) {
        APIResponse apiResponse = new APIResponse();
        return apiResponse;
    }

    public APIResponse selectByPrimaryKey(RoleUser record) {
        APIResponse apiResponse = new APIResponse();
        return apiResponse;
    }

    public APIResponse updateByPrimaryKeySelective(RoleUser record) {
        APIResponse apiResponse = new APIResponse();
        return apiResponse;
    }

    public APIResponse updateByPrimaryKey(RoleUser record) {
        APIResponse apiResponse = new APIResponse();
        return apiResponse;
    }

    public APIResponse selectList(RoleUser record) {
        APIResponse apiResponse = new APIResponse();
        return apiResponse;
    }
}