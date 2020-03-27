package com.common.dao.mapper;

import com.common.dao.entity.Test2;
import java.util.List;
import javax.annotation.Resource;

@Resource
public interface Test2MapperExt extends Test2Mapper {
    List<Test2> selectList(Test2 record);
}