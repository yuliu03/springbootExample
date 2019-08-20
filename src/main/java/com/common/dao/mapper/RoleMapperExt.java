package com.common.dao.mapper;

import com.common.dao.entity.Role;
import java.util.List;
import javax.annotation.Resource;

@Resource
public interface RoleMapperExt extends RoleMapper {
    List<Role> selectList(Role record);
}