package com.scrapy.service;
import com.common.dao.entity.RoleUser;
import com.scrapy.common.APIResponse;

public interface RoleUserService {
    APIResponse deleteByPrimaryKey(RoleUser record);

    APIResponse insert(RoleUser record);

    APIResponse selectByPrimaryKey(RoleUser record);

    APIResponse updateByPrimaryKeySelective(RoleUser record);

    APIResponse updateByPrimaryKey(RoleUser record);

    APIResponse selectList(RoleUser record);
}