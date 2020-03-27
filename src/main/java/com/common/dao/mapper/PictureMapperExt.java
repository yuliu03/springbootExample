package com.common.dao.mapper;

import com.common.dao.entity.Picture;

import java.util.List;
import javax.annotation.Resource;

@Resource
public interface PictureMapperExt extends PictureMapper {
    List<Picture> selectList(Picture record);
}