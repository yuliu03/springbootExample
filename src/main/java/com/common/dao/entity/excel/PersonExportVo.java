package com.common.dao.entity.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class PersonExportVo implements Serializable {

    private static final long serialVersionUID = 1L;

    public PersonExportVo(String name, String username, String phoneNumber, String imageUrl) {
        this.name = name;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.imageUrl = imageUrl;
    }


    /**
     * 姓名
     */
    @Excel(name = "姓名", orderNum = "0", width = 15)
    private String name;

    /**
     * 登录用户名
     */
    @Excel(name = "用户名", orderNum = "1", width = 15)
    private String username;

    @Excel(name = "手机号码", orderNum = "2", width = 15)
    private String phoneNumber;

    /**
     * 人脸图片
     */
    @Excel(name = "人脸图片", orderNum = "3", width = 15, height = 30)
    private String imageUrl;


}
