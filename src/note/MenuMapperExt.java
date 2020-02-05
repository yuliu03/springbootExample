package com.common.dao.mapper;

import com.common.dao.entity.Menu;
import com.common.dao.entity.entityJsonBean.MenuJsonBean;

import java.util.List;
import javax.annotation.Resource;

@Resource
public interface MenuMapperExt extends MenuMapper {
    List<MenuJsonBean> selectListRecursive(Menu record);
}