package com.common.dao.mapper;

import com.common.dao.entity.RoleUser;

public interface RoleUserMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(RoleUser record);

    int insertSelective(RoleUser record);

    RoleUser selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(RoleUser record);

    int updateByPrimaryKey(RoleUser record);
}