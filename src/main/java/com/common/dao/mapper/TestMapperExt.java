package com.common.dao.mapper;

import com.common.dao.entity.Test;
import java.util.List;
import javax.annotation.Resource;

@Resource
public interface TestMapperExt extends TestMapper {
    List<Test> selectList(Test record);
}