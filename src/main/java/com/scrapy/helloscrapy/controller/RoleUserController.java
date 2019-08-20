package com.scrapy.helloscrapy.controller;
import com.common.dao.entity.RoleUser;
import com.scrapy.helloscrapy.common.APIResponse;
import com.scrapy.helloscrapy.service.RoleUserService;
import javax.servlet.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/RoleUser/")
class RoleUserController {
    @Autowired
    public RoleUserService roleUserService;

    @RequestMapping(value = "deleteByPrimaryKey",method = RequestMethod.POST)
    public APIResponse deleteByPrimaryKey(HttpServletRequest request, HttpSession session, @RequestBody RoleUser record) {
        APIResponse apiResponse = roleUserService.deleteByPrimaryKey(record);return apiResponse;
    }

    @RequestMapping(value = "insert",method = RequestMethod.POST)
    public APIResponse insert(HttpServletRequest request, HttpSession session, @RequestBody RoleUser record) {
        APIResponse apiResponse = roleUserService.insert(record);return apiResponse;
    }

    @RequestMapping(value = "selectByPrimaryKey",method = RequestMethod.POST)
    public APIResponse selectByPrimaryKey(HttpServletRequest request, HttpSession session, @RequestBody RoleUser record) {
        APIResponse apiResponse = roleUserService.selectByPrimaryKey(record);return apiResponse;
    }

    @RequestMapping(value = "updateByPrimaryKeySelective",method = RequestMethod.POST)
    public APIResponse updateByPrimaryKeySelective(HttpServletRequest request, HttpSession session, @RequestBody RoleUser record) {
        APIResponse apiResponse = roleUserService.updateByPrimaryKeySelective(record);return apiResponse;
    }

    @RequestMapping(value = "updateByPrimaryKey",method = RequestMethod.POST)
    public APIResponse updateByPrimaryKey(HttpServletRequest request, HttpSession session, @RequestBody RoleUser record) {
        APIResponse apiResponse = roleUserService.updateByPrimaryKey(record);return apiResponse;
    }

    @RequestMapping(value = "selectList",method = RequestMethod.POST)
    public APIResponse selectList(HttpServletRequest request, HttpSession session, @RequestBody RoleUser record) {
        APIResponse apiResponse = roleUserService.selectList(record);return apiResponse;
    }
}