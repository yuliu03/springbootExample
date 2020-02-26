package com.common.dao.mapper;

import com.common.dao.entity.Picture;

public interface PictureMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Picture record);

    int insertSelective(Picture record);

    Picture selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Picture record);

    int updateByPrimaryKey(Picture record);
}