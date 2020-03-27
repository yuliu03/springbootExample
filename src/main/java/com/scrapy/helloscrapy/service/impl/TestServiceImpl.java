package com.scrapy.helloscrapy.service.impl;
import com.common.dao.mapper.TestMapperExt;
import com.common.dao.entity.Test;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scrapy.helloscrapy.common.APIResponse;
import com.scrapy.helloscrapy.service.TestService;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class TestServiceImpl implements TestService {
    @Autowired
    public TestMapperExt testMapperExt;

    public APIResponse deleteByPrimaryKey(Test record) {
        APIResponse apiResponse = new APIResponse();
        if(testMapperExt.updateByPrimaryKeySelective(record) > 0){
                apiResponse.setCode(APIResponse.SUCCESS);
        }else{
                apiResponse.setCode(APIResponse.FAIL);
        }
        return apiResponse;
    }

    public APIResponse insert(Test record) {
        APIResponse apiResponse = new APIResponse();
       if(record.getUuid() == null || record.getUuid().equals("")){
            String uuid = UUID.randomUUID().toString();
            record.setUuid(uuid);
        }
        if(testMapperExt.insert(record) > 0){
                apiResponse.setCode(APIResponse.SUCCESS);
        }else{
                apiResponse.setCode(APIResponse.FAIL);
        }
        return apiResponse;
    }

    public APIResponse selectByPrimaryKey(Test record) {
        APIResponse apiResponse = new APIResponse();
        Test data = testMapperExt.selectByPrimaryKey(record.getUuid());
         if(data != null){
                apiResponse.setData(data);
                apiResponse.setCode(APIResponse.SUCCESS);
         }else{
                 apiResponse.setCode(APIResponse.FAIL);
         }
         return apiResponse;
    }

    public APIResponse updateByPrimaryKeySelective(Test record) {
        APIResponse apiResponse = new APIResponse();
        if(testMapperExt.updateByPrimaryKeySelective(record) > 0){
                apiResponse.setCode(APIResponse.SUCCESS);
        }else{
                apiResponse.setCode(APIResponse.FAIL);
        }
        return apiResponse;
    }

    public APIResponse updateByPrimaryKey(Test record) {
        APIResponse apiResponse = new APIResponse();
        if(testMapperExt.updateByPrimaryKeySelective(record) > 0){
                apiResponse.setCode(APIResponse.SUCCESS);
        }else{
                apiResponse.setCode(APIResponse.FAIL);
        }
        return apiResponse;
    }

    public APIResponse selectList(Test record) {
        APIResponse apiResponse = new APIResponse();
       int startPage = record.getPageNum();
       int pageSize = record.getPageSize();
       record.setIsDel((byte) 0);
       PageHelper.startPage(startPage, pageSize);
       List<Test> tmpList= testMapperExt.selectList(record);
       PageInfo<Test> tmpPageInfo = new PageInfo<Test>(tmpList);
       apiResponse.setData(tmpPageInfo);
       apiResponse.setTotal((int) tmpPageInfo.getTotal());
       apiResponse.setCode(APIResponse.SUCCESS);
       return  apiResponse;
    }
}