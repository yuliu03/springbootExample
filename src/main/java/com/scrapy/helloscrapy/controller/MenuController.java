package com.scrapy.helloscrapy.controller;
import com.common.dao.entity.Menu;
import com.scrapy.helloscrapy.common.APIResponse;
import com.scrapy.helloscrapy.service.MenuService;
import javax.servlet.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/Menu/")
class MenuController {
    @Autowired
    public MenuService menuService;

    @RequestMapping(value = "deleteByPrimaryKey",method = RequestMethod.POST)
    public APIResponse deleteByPrimaryKey(HttpServletRequest request, HttpSession session, @RequestBody Menu record) {
        APIResponse apiResponse = menuService.deleteByPrimaryKey(record);return apiResponse;
    }

    @RequestMapping(value = "insert",method = RequestMethod.POST)
    public APIResponse insert(HttpServletRequest request, HttpSession session, @RequestBody Menu record) {
        APIResponse apiResponse = menuService.insert(record);return apiResponse;
    }

    @RequestMapping(value = "selectByPrimaryKey",method = RequestMethod.POST)
    public APIResponse selectByPrimaryKey(HttpServletRequest request, HttpSession session, @RequestBody Menu record) {
        APIResponse apiResponse = menuService.selectByPrimaryKey(record);return apiResponse;
    }

    @RequestMapping(value = "updateByPrimaryKeySelective",method = RequestMethod.POST)
    public APIResponse updateByPrimaryKeySelective(HttpServletRequest request, HttpSession session, @RequestBody Menu record) {
        APIResponse apiResponse = menuService.updateByPrimaryKeySelective(record);return apiResponse;
    }

    @RequestMapping(value = "updateByPrimaryKey",method = RequestMethod.POST)
    public APIResponse updateByPrimaryKey(HttpServletRequest request, HttpSession session, @RequestBody Menu record) {
        APIResponse apiResponse = menuService.updateByPrimaryKey(record);return apiResponse;
    }

    @RequestMapping(value = "selectList",method = RequestMethod.POST)
    public APIResponse selectList(HttpServletRequest request, HttpSession session, @RequestBody(required = false) Menu record) {
        APIResponse apiResponse = menuService.selectList(record);return apiResponse;
    }

    @RequestMapping(value = "selectListRecursive",method = RequestMethod.POST)
    public APIResponse selectListRecursive(HttpServletRequest request, HttpSession session, @RequestBody(required = false) Menu record) {
        APIResponse apiResponse = menuService.selectListRecursive(record);return apiResponse;
    }
}