package com.scrapy.helloscrapy.service;
import com.common.dao.entity.RoleUser;
import com.scrapy.helloscrapy.common.APIResponse;

public interface RoleUserService {
    APIResponse deleteByPrimaryKey(RoleUser record);

    APIResponse insert(RoleUser record);

    APIResponse selectByPrimaryKey(RoleUser record);

    APIResponse updateByPrimaryKeySelective(RoleUser record);

    APIResponse updateByPrimaryKey(RoleUser record);

    APIResponse selectList(RoleUser record);
}