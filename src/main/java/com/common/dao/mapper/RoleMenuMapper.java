package com.common.dao.mapper;

import com.common.dao.entity.RoleMenu;

public interface RoleMenuMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(RoleMenu record);

    int insertSelective(RoleMenu record);

    RoleMenu selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(RoleMenu record);

    int updateByPrimaryKey(RoleMenu record);
}