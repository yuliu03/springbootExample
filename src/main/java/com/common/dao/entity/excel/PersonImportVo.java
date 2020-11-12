package com.common.dao.entity.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.handler.inter.IExcelDataModel;
import cn.afterturn.easypoi.handler.inter.IExcelModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonImportVo implements IExcelModel, IExcelDataModel {
    @NotNull(message = "姓名不能为空")
    @Excel(name = "用户ID", width = 15)
    private Integer userId;

    @Excel(name = "用户名", width = 15)
    private String userName;

    @Excel(name = "用户性别", width = 15)
    private String userSex;

    @Excel(name = "用户年龄", width = 15)
    private Integer userAge;

    private int rowNum;

    private String errorMsg;

    @Override
    public int getRowNum() {
        return rowNum;
    }

    @Override
    public void setRowNum(int i) {
        rowNum = i;
    }

    @Override
    public String getErrorMsg() {
        return errorMsg;
    }

    @Override
    public void setErrorMsg(String s) {
        errorMsg = s;
    }
}
