package com.scrapy.helloscrapy.service;
import com.common.dao.entity.Role;
import com.scrapy.helloscrapy.common.APIResponse;

public interface RoleService {
    APIResponse deleteByPrimaryKey(Role record);

    APIResponse insert(Role record);

    APIResponse selectByPrimaryKey(Role record);

    APIResponse updateByPrimaryKeySelective(Role record);

    APIResponse updateByPrimaryKey(Role record);

    APIResponse selectList(Role record);
}