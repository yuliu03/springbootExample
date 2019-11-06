package com.scrapy.helloscrapy.service;
import com.common.dao.entity.RoleMenu;
import com.scrapy.helloscrapy.common.APIResponse;

public interface RoleMenuService {
    APIResponse deleteByPrimaryKey(RoleMenu record);

    APIResponse insert(RoleMenu record);

    APIResponse selectByPrimaryKey(RoleMenu record);

    APIResponse updateByPrimaryKeySelective(RoleMenu record);

    APIResponse updateByPrimaryKey(RoleMenu record);

    APIResponse selectList(RoleMenu record);
}