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

    @Value("${file.uploadFolder.img}")
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
    public APIResponse upload_img(@RequestParam(value = "pic", required = false) MultipartFile multipartFile, HttpServletResponse response) {
        try {
            // 保存图片
            File file = new File(imgPath + multipartFile.getOriginalFilename());
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }


            // 保存图片
            APIResponse apiResponse = new APIResponse();
            String url = imgPath + multipartFile.getOriginalFilename();
            File file = new File(url);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition",
                        "attachment;fileName=" +  multipartFile.getOriginalFilename());// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("success");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        return null;
    }
}