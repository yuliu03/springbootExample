package com.scrapy.service.impl;
import com.common.dao.entity.Picture;
import com.common.dao.mapper.PictureMapperExt;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scrapy.common.APIResponse;
import com.scrapy.service.PictureService;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class PictureServiceImpl implements PictureService {
    @Autowired
    public PictureMapperExt pictureMapperExt;



    public APIResponse deleteByPrimaryKey(Picture record) {
        APIResponse apiResponse = new APIResponse();
        if(pictureMapperExt.updateByPrimaryKeySelective(record) > 0){
                apiResponse.setCode(APIResponse.SUCCESS);
        }else{
                apiResponse.setCode(APIResponse.FAIL);
        }
        return apiResponse;
    }

    public APIResponse insert(Picture record) {
        APIResponse apiResponse = new APIResponse();
       if(record.getUuid() == null || record.getUuid().equals("")){
            String uuid = UUID.randomUUID().toString();
            record.setUuid(uuid);
        }
        if(pictureMapperExt.insert(record) > 0){
                apiResponse.setCode(APIResponse.SUCCESS);
        }else{
                apiResponse.setCode(APIResponse.FAIL);
        }
        return apiResponse;
    }

    public APIResponse selectByPrimaryKey(Picture record) {
        APIResponse apiResponse = new APIResponse();
        Picture data = pictureMapperExt.selectByPrimaryKey(record.getUuid());
         if(data != null){
                apiResponse.setData(data);
                apiResponse.setCode(APIResponse.SUCCESS);
         }else{
                 apiResponse.setCode(APIResponse.FAIL);
         }
         return apiResponse;
    }

    public APIResponse updateByPrimaryKeySelective(Picture record) {
        APIResponse apiResponse = new APIResponse();
        if(pictureMapperExt.updateByPrimaryKeySelective(record) > 0){
                apiResponse.setCode(APIResponse.SUCCESS);
        }else{
                apiResponse.setCode(APIResponse.FAIL);
        }
        return apiResponse;
    }

    public APIResponse updateByPrimaryKey(Picture record) {
        APIResponse apiResponse = new APIResponse();
        if(pictureMapperExt.updateByPrimaryKeySelective(record) > 0){
                apiResponse.setCode(APIResponse.SUCCESS);
        }else{
                apiResponse.setCode(APIResponse.FAIL);
        }
        return apiResponse;
    }

    public APIResponse selectList(Picture record) {
        APIResponse apiResponse = new APIResponse();
       int startPage = record.getPageNum();
       int pageSize = record.getPageSize();
       PageHelper.startPage(startPage, pageSize);
       List<Picture> tmpList= pictureMapperExt.selectList(record);
       PageInfo<Picture> tmpPageInfo = new PageInfo<Picture>(tmpList);
       apiResponse.setData(tmpPageInfo);
       apiResponse.setTotal((int) tmpPageInfo.getTotal());
       apiResponse.setCode(APIResponse.SUCCESS);
       return  apiResponse;
    }
}