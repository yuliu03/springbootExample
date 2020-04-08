package com.scrapy.service;
import com.common.dao.entity.RoleMenu;
import com.scrapy.common.APIResponse;

public interface RoleMenuService {
    APIResponse deleteByPrimaryKey(RoleMenu record);

    APIResponse insert(RoleMenu record);

    APIResponse selectByPrimaryKey(RoleMenu record);

    APIResponse updateByPrimaryKeySelective(RoleMenu record);

    APIResponse updateByPrimaryKey(RoleMenu record);

    APIResponse selectList(RoleMenu record);
}