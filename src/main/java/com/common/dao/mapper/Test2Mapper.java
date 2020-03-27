package com.common.dao.mapper;

import com.common.dao.entity.Test2;

public interface Test2Mapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Test2 record);

    int insertSelective(Test2 record);

    Test2 selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Test2 record);

    int updateByPrimaryKey(Test2 record);
}