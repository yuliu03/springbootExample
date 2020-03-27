package com.scrapy.helloscrapy.controller;

import com.scrapy.helloscrapy.common.APIResponse;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value ="/excel/")
public class ExcelController {
    private final static String EXCEL_2003_DOWN = ".xls"; // 2003- 版本的excel
    private final static String EXCEL_2007_UP = ".xlsx"; // 2007+ 版本的excel

    @RequestMapping(value = "file",method = RequestMethod.POST)
    @ResponseBody
    public APIResponse fileUpload(@RequestParam(value = "file", required = false) MultipartFile file){
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
        APIResponse apiResponse = new APIResponse<>();
        try {
            InputStream in = file.getInputStream();
            ArrayList<Object> listToReturn = new ArrayList<Object>();
            // 创建Excel工作薄
            Workbook work = this.getWorkbook(in, fileName);
            if (null == work) {
                throw new Exception("创建Excel工作薄为空或excel格式不对！");
            }
            Sheet sheet = work.getSheetAt(0);
            //遍历行
            for (int i = sheet.getFirstRowNum(); i < sheet.getLastRowNum() + 1; i++) {
                Row row= sheet.getRow(i);
                if (row == null) {
                    continue;
                }
                //遍历列
                for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
                    Cell cell = row.getCell(j);
                    Object cellValue = this.getCellValue(cell);
                    if(cell != null){
                        //do something
                        System.out.print(cell.toString());
                    }
                }
            }
            apiResponse.setMessage("上传成功");
            apiResponse.setData(listToReturn);
            apiResponse.setCode(APIResponse.SUCCESS);
            return apiResponse;
        } catch (Exception e) {
            e.printStackTrace();
            apiResponse.setCode(APIResponse.FAIL);
            return apiResponse;
        }
    }


    private Workbook getWorkbook(InputStream inStr, String fileName) throws Exception {
        Workbook wb = null;
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        if (EXCEL_2003_DOWN.equals(fileType)) {
            wb = new HSSFWorkbook(inStr); // 2003-
        } else if (EXCEL_2007_UP.equals(fileType)) {
            wb = new XSSFWorkbook(inStr); //2007+
        }
        return wb;
    }

    /*
     * excel 内容上传
     */
    @RequestMapping(value = "info",method = RequestMethod.POST)
    public APIResponse fileUploadInfo(HttpServletRequest request, HttpSession session, @RequestBody List<Object> record) {
        APIResponse apiResponse = new APIResponse<>();
        if (record == null || record.isEmpty()){
            apiResponse.setMessage("内容是空");
            apiResponse.setData(record);
            apiResponse.setCode(APIResponse.FAIL);
        }else{
            apiResponse.setMessage("上传成功");
            apiResponse.setData(record);
            apiResponse.setCode(APIResponse.SUCCESS);
            return apiResponse;
        }

        return apiResponse;
    }

    private Object getCellValue(Cell cell) {
        if (cell != null) {
            Object value = null;
            DecimalFormat df = new DecimalFormat("0"); // 格式化number String字符
            SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd"); // 日期格式化
            DecimalFormat df2 = new DecimalFormat("0.00"); // 格式化数字
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_STRING:
                    value = cell.getRichStringCellValue().getString();
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    if ("General".equals(cell.getCellStyle().getDataFormatString())) {
                        value = df.format(cell.getNumericCellValue());
                    } else if ("m/d/yy".equals(cell.getCellStyle().getDataFormatString())) {
                        value = sdf.format(cell.getDateCellValue());
                    } else {
                        value = df2.format(cell.getNumericCellValue());
                    }
                    break;
                case Cell.CELL_TYPE_BOOLEAN:
                    value = cell.getBooleanCellValue();
                    break;
                case Cell.CELL_TYPE_BLANK:
                    value = "";
                    break;
                default:
                    break;
            }
            return value;
        }else{
            return "";
        }

    }
}
