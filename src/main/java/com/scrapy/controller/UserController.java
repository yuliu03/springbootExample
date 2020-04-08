package com.scrapy.controller;
import com.common.dao.entity.User;
import com.common.dao.entity.entityJsonBean.SessionUserJsonBean;
import com.scrapy.common.APIResponse;
import com.scrapy.service.UserService;
import javax.servlet.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

@RestController
@RequestMapping(value ="/User/")
class UserController {
    @Autowired
    public UserService userService;

    @RequestMapping(value = "deleteByPrimaryKey",method = RequestMethod.POST)
    public APIResponse deleteByPrimaryKey(HttpServletRequest request, HttpSession session, @RequestBody User record) {
        APIResponse apiResponse = userService.deleteByPrimaryKey(record);return apiResponse;
    }

    @RequestMapping(value = "insert",method = RequestMethod.POST)
    public APIResponse insert(HttpServletRequest request, HttpSession session, @RequestBody User record) {
        APIResponse apiResponse = userService.insert(record);return apiResponse;
    }

    @RequestMapping(value = "selectByPrimaryKey",method = RequestMethod.POST)
    public APIResponse selectByPrimaryKey(HttpServletRequest request, HttpSession session, @RequestBody User record) {
        APIResponse apiResponse = userService.selectByPrimaryKey(record);return apiResponse;
    }

    @RequestMapping(value = "updateByPrimaryKeySelective",method = RequestMethod.POST)
    public APIResponse updateByPrimaryKeySelective(HttpServletRequest request, HttpSession session, @RequestBody User record) {
        APIResponse apiResponse = userService.updateByPrimaryKeySelective(record);return apiResponse;
    }

    @RequestMapping(value = "updateByPrimaryKey",method = RequestMethod.POST)
    public APIResponse updateByPrimaryKey(HttpServletRequest request, HttpSession session, @RequestBody User record) {
        APIResponse apiResponse = userService.updateByPrimaryKey(record);
        return apiResponse;
    }

    @RequestMapping(value = "selectList",method = RequestMethod.POST)
    public APIResponse selectList(HttpServletRequest request, HttpSession session, @RequestBody User record) {
        APIResponse apiResponse = userService.selectList(record);return apiResponse;
    }

    //////////////////

    /**
     * post请求，
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public APIResponse login(HttpServletRequest request, @RequestBody(required = true) User user){
        APIResponse apiResponse = userService.login(user);
        return apiResponse;
    }

    /**
     * 判断用户的session是否有效（在同一个浏览器中，同一个域中，每次Request请求，都会带上Session）
     * @param request
     * @return
     */
    @RequestMapping(value = "isValid",method = RequestMethod.GET)
    public String isSessionValid(HttpServletRequest request){
        //简化if-else表达式
        String toReturn = request.isRequestedSessionIdValid() ? "ok" : "no";
        return toReturn;
    }

    /**
     * 注销登录
     * @param session
     * @return
     */
    @RequestMapping(value = "logout",method = RequestMethod.POST)
    public void logout(HttpSession session, HttpServletRequest request,@RequestBody(required = true) SessionUserJsonBean user){
        userService.logout(user);
    }

    /*
     * 时间区间过滤查询
     */
    @RequestMapping(value = "selectListByFilter",method = RequestMethod.POST)
    public APIResponse selectListByFilter(HttpServletRequest request, HttpSession session, @RequestBody Map<String,String> record) {
        if (record == null || record.isEmpty()){
            return new APIResponse(APIResponse.NOT_INITIALIZED);
        }else{
            APIResponse apiResponse = userService.selectListByFilter(record);
            return apiResponse;
        }
    }

    /*
     * 时间区间过滤查询
     */
    @RequestMapping(value = "singleLogicDel",method = RequestMethod.POST)
    public APIResponse singleLogicDel(HttpServletRequest request, HttpSession session, @RequestBody User record) {
        if (record == null || record.getUuid() == ""){
            return new APIResponse(APIResponse.NOT_INITIALIZED);
        }else{
            //获取主要信息，防止被恶意篡改
            User tmpRecord = new User();
            tmpRecord.setUuid(record.getUuid());
            //根据uuid获取所有信息，只更改is_del内容，因为直接调用updateSelect会把虽有的内容都更改了
//            tmpRecord=(User)userService.selectByPrimaryKey(tmpRecord).getData();

            tmpRecord.setIsDel((byte) 1);
            APIResponse apiResponse = userService.updateByPrimaryKeySelective(tmpRecord);
            return apiResponse;
        }
    }

}