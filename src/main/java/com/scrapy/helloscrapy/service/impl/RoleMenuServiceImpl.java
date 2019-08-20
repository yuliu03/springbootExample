package com.scrapy.helloscrapy.service.impl;
import com.common.dao.entity.RoleMenu;
import com.common.dao.mapper.RoleMenuMapperExt;
import com.scrapy.helloscrapy.common.APIResponse;
import com.scrapy.helloscrapy.service.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class RoleMenuServiceImpl implements RoleMenuService {
    @Autowired
    public RoleMenuMapperExt roleMenuMapperExt;

    public APIResponse deleteByPrimaryKey(RoleMenu record) {
        APIResponse apiResponse = new APIResponse();
        return apiResponse;
    }

    public APIResponse insert(RoleMenu record) {
        APIResponse apiResponse = new APIResponse();
        return apiResponse;
    }

    public APIResponse selectByPrimaryKey(RoleMenu record) {
        APIResponse apiResponse = new APIResponse();
        return apiResponse;
    }

    public APIResponse updateByPrimaryKeySelective(RoleMenu record) {
        APIResponse apiResponse = new APIResponse();
        return apiResponse;
    }

    public APIResponse updateByPrimaryKey(RoleMenu record) {
        APIResponse apiResponse = new APIResponse();
        return apiResponse;
    }

    public APIResponse selectList(RoleMenu record) {
        APIResponse apiResponse = new APIResponse();
        return apiResponse;
    }
}