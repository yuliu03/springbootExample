package com.common.dao.mapper;

import com.common.dao.entity.User;
import java.util.List;
import javax.annotation.Resource;

@Resource
public interface UserMapperExt extends UserMapper {
    List<User> selectList(User record);
}