package com.scrapy.helloscrapy.controller;
import com.common.dao.entity.Picture;
import com.scrapy.helloscrapy.common.APIResponse;
import com.scrapy.helloscrapy.service.PictureService;
import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
@RequestMapping(value ="/Picture/")
class PictureController {
    @Autowired
    public PictureService pictureService;

    @Value("${path.uploadFolder.img}")
    private String imgPath;

    @RequestMapping(value = "deleteByPrimaryKey",method = RequestMethod.POST)
    public APIResponse deleteByPrimaryKey(HttpServletRequest request, HttpSession session, @RequestBody Picture record) {
        APIResponse apiResponse = pictureService.deleteByPrimaryKey(record);return apiResponse;
    }

    @RequestMapping(value = "insert",method = RequestMethod.POST)
    public APIResponse insert(HttpServletRequest request, HttpSession session, @RequestBody Picture record) {
        APIResponse apiResponse = pictureService.insert(record);return apiResponse;
    }

    @RequestMapping(value = "selectByPrimaryKey",method = RequestMethod.POST)
    public APIResponse selectByPrimaryKey(HttpServletRequest request, HttpSession session, @RequestBody Picture record) {
        APIResponse apiResponse = pictureService.selectByPrimaryKey(record);return apiResponse;
    }

    @RequestMapping(value = "updateByPrimaryKeySelective",method = RequestMethod.POST)
    public APIResponse updateByPrimaryKeySelective(HttpServletRequest request, HttpSession session, @RequestBody Picture record) {
        APIResponse apiResponse = pictureService.updateByPrimaryKeySelective(record);return apiResponse;
    }

    @RequestMapping(value = "updateByPrimaryKey",method = RequestMethod.POST)
    public APIResponse updateByPrimaryKey(HttpServletRequest request, HttpSession session, @RequestBody Picture record) {
        APIResponse apiResponse = pictureService.updateByPrimaryKey(record);return apiResponse;
    }

    @RequestMapping(value = "selectList",method = RequestMethod.POST)
    public APIResponse selectList(HttpServletRequest request, HttpSession session, @RequestBody Picture record) {
        APIResponse apiResponse = pictureService.selectList(record);return apiResponse;
    }



    @RequestMapping(value = "upload_img",method = RequestMethod.POST)
    @ResponseBody
    public APIResponse upload_img(@RequestParam(value = "pic", required = false) MultipartFile multipartFile) {
        try {
            // 保存图片
            String xImgPath = imgPath + multipartFile.getOriginalFilename();
            File file = new File(xImgPath);
            multipartFile.transferTo(file);
            Picture record = new Picture();
            record.setPictureUrl(xImgPath);
            return pictureService.insert(record);
        } catch (IOException e) {
            e.printStackTrace();
            APIResponse apiResponse = new APIResponse<>();
            apiResponse.setMessage("上传失败");
            apiResponse.setCode(APIResponse.FAIL);
            return apiResponse;
        }

    }
}