package com.common.dao.mapper;

import com.common.dao.entity.RoleMenu;
import java.util.List;
import javax.annotation.Resource;

@Resource
public interface RoleMenuMapperExt extends RoleMenuMapper {
    List<RoleMenu> selectList(RoleMenu record);
}