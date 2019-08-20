package com.scrapy.helloscrapy.controller;
import com.common.dao.entity.Role;
import com.scrapy.helloscrapy.common.APIResponse;
import com.scrapy.helloscrapy.service.RoleService;
import javax.servlet.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/Role/")
class RoleController {
    @Autowired
    public RoleService roleService;

    @RequestMapping(value = "deleteByPrimaryKey",method = RequestMethod.POST)
    public APIResponse deleteByPrimaryKey(HttpServletRequest request, HttpSession session, @RequestBody Role record) {
        APIResponse apiResponse = roleService.deleteByPrimaryKey(record);return apiResponse;
    }

    @RequestMapping(value = "insert",method = RequestMethod.POST)
    public APIResponse insert(HttpServletRequest request, HttpSession session, @RequestBody Role record) {
        APIResponse apiResponse = roleService.insert(record);return apiResponse;
    }

    @RequestMapping(value = "selectByPrimaryKey",method = RequestMethod.POST)
    public APIResponse selectByPrimaryKey(HttpServletRequest request, HttpSession session, @RequestBody Role record) {
        APIResponse apiResponse = roleService.selectByPrimaryKey(record);return apiResponse;
    }

    @RequestMapping(value = "updateByPrimaryKeySelective",method = RequestMethod.POST)
    public APIResponse updateByPrimaryKeySelective(HttpServletRequest request, HttpSession session, @RequestBody Role record) {
        APIResponse apiResponse = roleService.updateByPrimaryKeySelective(record);return apiResponse;
    }

    @RequestMapping(value = "updateByPrimaryKey",method = RequestMethod.POST)
    public APIResponse updateByPrimaryKey(HttpServletRequest request, HttpSession session, @RequestBody Role record) {
        APIResponse apiResponse = roleService.updateByPrimaryKey(record);return apiResponse;
    }

    @RequestMapping(value = "selectList",method = RequestMethod.POST)
    public APIResponse selectList(HttpServletRequest request, HttpSession session, @RequestBody Role record) {
        APIResponse apiResponse = roleService.selectList(record);return apiResponse;
    }
}