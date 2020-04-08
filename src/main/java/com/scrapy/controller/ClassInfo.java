package com.scrapy.controller;

import com.common.util.LocalUtil;
import com.scrapy.common.APIResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value ="/class/")
public class ClassInfo {
    @Value("${path.entityPath}")
    private String entityPath;
    @Value("${path.entityJsonPath}")
    private String entityJsonPath;
    @Value("${path.tmpFile}")
    private String tmpFile;
    @Value("${path.testSourceFile}")
    private String testSourceFile;
    @Value("${path.testSourcePath}")
    private String testSourcePath;


    @RequestMapping(value = "model",method = RequestMethod.POST)
    @ResponseBody
    public APIResponse getClassesList(HttpServletResponse res) throws Exception
    {
        ArrayList<Map> classList = new ArrayList<Map>();
        LocalUtil.getModelFiles(entityPath,classList);
        APIResponse apiResponse = new APIResponse();
        apiResponse.setData(classList);
        apiResponse.setCode(APIResponse.SUCCESS);
        return  apiResponse;
    }

    //    文件下载 zip
    @RequestMapping(value = "zip", method = RequestMethod.POST)
    public void zip(@RequestBody  List<String> classNames, HttpServletResponse res){
        String fileName = "zipFileName";
//        if(LocalUtil.fileToZip(testSourceFile, tmpFile, fileName)){
//            //System.out.println("zip path: "+ tmpFile+fileName);
//            fillResponse(fileName+".zip",res);
//        }
        System.out.println(testSourcePath);
        System.out.println(testSourcePath+"/x.zip");
        String zipPath = testSourcePath;
        LocalUtil.folderToZip(testSourcePath,zipPath,"x");
    }
    //    文件下载功能
    @RequestMapping(value = "code", method = RequestMethod.POST)
    public void code(@RequestBody  List<String> classNames, HttpServletResponse res){
        /////////////////////////////////////////////////////
        //只有单一的文件
        if (classNames.size() == 1){
            String fileName = classNames.get(0);
            fileName = "test.txt";
            fillResponse(fileName,res);
        }else{

        }
    }

    private void fillResponse(String fileName,HttpServletResponse res){
//        fileName = "test2.xls";

        res.setContentType("application/force-download");// 设置强制下载不打开
        res.setCharacterEncoding("UTF-8");
        res.setHeader("content-type", "application/octet-stream;charset=UTF-8");
        res.setContentType("application/octet-stream;charset=UTF-8");
        File readFile = new File(tmpFile + fileName);
        int fileLength = (int) readFile.length();
        System.out.println(fileLength);
        byte[] buff = new byte[fileLength];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            os = res.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(readFile));
            int i = bis.read(buff);
            while (i != -1) {
                os.write(buff, 0, buff.length);
                os.flush();
                i = bis.read(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
            res.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
