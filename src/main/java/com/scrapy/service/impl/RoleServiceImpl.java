package com.scrapy.service.impl;
import com.common.dao.entity.Role;
import com.common.dao.mapper.RoleMapperExt;
import com.scrapy.common.APIResponse;
import com.scrapy.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class RoleServiceImpl implements RoleService {
    @Autowired
    public RoleMapperExt roleMapperExt;

    public APIResponse deleteByPrimaryKey(Role record) {
        APIResponse apiResponse = new APIResponse();
        return apiResponse;
    }

    public APIResponse insert(Role record) {
        APIResponse apiResponse = new APIResponse();
        return apiResponse;
    }

    public APIResponse selectByPrimaryKey(Role record) {
        APIResponse apiResponse = new APIResponse();
        return apiResponse;
    }

    public APIResponse updateByPrimaryKeySelective(Role record) {
        APIResponse apiResponse = new APIResponse();
        return apiResponse;
    }

    public APIResponse updateByPrimaryKey(Role record) {
        APIResponse apiResponse = new APIResponse();
        return apiResponse;
    }

    public APIResponse selectList(Role record) {
        APIResponse apiResponse = new APIResponse();
        return apiResponse;
    }
}