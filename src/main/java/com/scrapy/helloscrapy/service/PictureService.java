package com.scrapy.helloscrapy.service;
import com.common.dao.entity.Picture;
import com.scrapy.helloscrapy.common.APIResponse;

public interface PictureService {
    APIResponse deleteByPrimaryKey(Picture record);

    APIResponse insert(Picture record);

    APIResponse selectByPrimaryKey(Picture record);

    APIResponse updateByPrimaryKeySelective(Picture record);

    APIResponse updateByPrimaryKey(Picture record);

    APIResponse selectList(Picture record);
}