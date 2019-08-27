package com.scrapy.helloscrapy.service;
import com.common.dao.entity.Menu;
import com.scrapy.helloscrapy.common.APIResponse;

public interface MenuService {
    APIResponse deleteByPrimaryKey(Menu record);

    APIResponse insert(Menu record);

    APIResponse selectByPrimaryKey(Menu record);

    APIResponse updateByPrimaryKeySelective(Menu record);

    APIResponse updateByPrimaryKey(Menu record);

    APIResponse selectList(Menu record);
}