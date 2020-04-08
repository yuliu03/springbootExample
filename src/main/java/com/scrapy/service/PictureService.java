package com.scrapy.service;
import com.common.dao.entity.Picture;
import com.scrapy.common.APIResponse;

public interface PictureService {
    APIResponse deleteByPrimaryKey(Picture record);

    APIResponse insert(Picture record);

    APIResponse selectByPrimaryKey(Picture record);

    APIResponse updateByPrimaryKeySelective(Picture record);

    APIResponse updateByPrimaryKey(Picture record);

    APIResponse selectList(Picture record);
}