package com.common.dao.mapper;

import com.common.dao.entity.RoleUser;

import java.util.List;
import javax.annotation.Resource;

@Resource
public interface RoleUserMapperExt extends RoleUserMapper {
    List<RoleUser> selectList(RoleUser record);
}