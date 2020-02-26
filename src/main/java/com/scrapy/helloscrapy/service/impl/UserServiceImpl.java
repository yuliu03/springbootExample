package com.scrapy.helloscrapy.service.impl;
import com.common.dao.entity.User;
import com.common.dao.entity.entityJsonBean.SessionUserJsonBean;
import com.common.dao.mapper.UserMapperExt;
import com.scrapy.helloscrapy.common.APIResponse;
import com.scrapy.helloscrapy.common.GlobalConfigParam;
import com.scrapy.helloscrapy.common.RedisUtil;
import com.scrapy.helloscrapy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
class UserServiceImpl implements UserService {
    @Autowired
    public UserMapperExt userMapperExt;
    @Autowired
    private RedisUtil redisUtil;

    public APIResponse deleteByPrimaryKey(User record) {
        APIResponse apiResponse = new APIResponse();
        return apiResponse;
    }

    public APIResponse insert(User record) {
        if(record.getUuid() == null || record.getUuid().equals("")){
            String uuid = UUID.randomUUID().toString();
            record.setUuid(uuid);
        }

        APIResponse apiResponse = new APIResponse();
        if(userMapperExt.insert(record) > 0){
            apiResponse.setCode(APIResponse.SUCCESS);
        }else{
            apiResponse.setCode(APIResponse.FAIL);
        }
        return apiResponse;
    }

    public APIResponse selectByPrimaryKey(User record) {
        APIResponse apiResponse = new APIResponse();
        return apiResponse;
    }

    public APIResponse updateByPrimaryKeySelective(User record) {
        APIResponse apiResponse = new APIResponse();
        if(userMapperExt.updateByPrimaryKeySelective(record) > 0){
            apiResponse.setCode(APIResponse.SUCCESS);
        }else{
            apiResponse.setCode(APIResponse.FAIL);
        }
        return apiResponse;
    }

    public APIResponse updateByPrimaryKey(User record) {
        APIResponse apiResponse = new APIResponse();
        return apiResponse;
    }

    public APIResponse selectList(User record) {
        APIResponse apiResponse = new APIResponse();
        //排序实现: 数据库字段 + " desc" 或 数据库字段 + " asc"
        int startPage = record.getPageNum();
        int pageSize = record.getPageSize();

        //过滤已被删除的数据
        record.setIsDel((byte) 0);

        PageHelper.startPage(startPage, pageSize);
        List<User> userList= userMapperExt.selectList(record);

        PageInfo<User> userPageInfo = new PageInfo<User>(userList);
        apiResponse.setData(userPageInfo);
        apiResponse.setTotal((int) userPageInfo.getTotal());
        apiResponse.setCode(APIResponse.SUCCESS);
        return  apiResponse;
    }

    @Override
    public APIResponse login(User record) {
        List<User> users= userMapperExt.selectList(record);
        User user;
        if (users.isEmpty()){
            return APIResponse.fail("账号或者密码错误");
        }else {
            /*如果已经存在Session的话，直接返回它；没有就创建一个，再返回
             * 当然Session是自动放在response中的Header中的，这里不用做其他处理*/
            user = users.get(0);
        }

        //生成token
        String token = UUID.randomUUID().toString().replace("-","");
        SessionUserJsonBean sessionUserJsonBean = new SessionUserJsonBean(token, GlobalConfigParam.SESSION_TIME,new HashMap<>());

        //获取user 的 uuid， 放入session中
        sessionUserJsonBean.put("uuid",user.getUuid());

        redisUtil.set(token,sessionUserJsonBean);
        redisUtil.expire(token,GlobalConfigParam.SESSION_TIME);
//        SessionUserJsonBean myMap = (SessionUserJsonBean) redisUtil.get(GlobalConfigParam.TOKEN+token);
        return APIResponse.success(new SessionUserJsonBean(token, GlobalConfigParam.SESSION_TIME,null));
    }

    @Override
    public void logout(SessionUserJsonBean sessionUserJsonBean) {
        redisUtil.del(sessionUserJsonBean.getToken());
    }

    @Override
    public APIResponse selectListByFilter(Map<String, String> record) {
        User selectUserListCondition = new User();

        String userid = (String)record.get("userId");
        if(userid != null && !userid.equals("")){
            selectUserListCondition.setUserId(userid);
        }

        String password = (String)record.get("password");
        if(password != null && !password.equals("")){
            selectUserListCondition.setPassword(password);
        }

        String userFullName = (String)record.get("userFullName");
        if(userFullName != null && !userFullName.equals("")){
            selectUserListCondition.setUserName(userFullName);
        }

//        String startTime = (String)record.get("startTime");
//        if(startTime != null && !startTime.equals("")){
//            selectUserListCondition.setUserFullName(userFullName);
//        }
//
//        String userFullName = (String)record.get("userFullName");
//        if(userFullName != null && !userFullName.equals("")){
//            selectUserListCondition.setUserFullName(userFullName);
//        }


        String pageNum = (String)record.get("pageNum");
        if(pageNum != null && !pageNum.equals("") && !pageNum.equals("0")){
            selectUserListCondition.setPageNum(Integer.parseInt(pageNum));
        }else{
            selectUserListCondition.setPageNum(1);
        }

        String pageSize = (String)record.get("pageSize");
        if(pageSize != null && !pageSize.equals("") && !pageSize.equals("0")){
            selectUserListCondition.setPageSize(Integer.parseInt(pageSize));
        }else{
            selectUserListCondition.setPageSize(10);
        }

        //过滤已被删除的数据
        selectUserListCondition.setIsDel((byte) 0);

        PageHelper.startPage(selectUserListCondition.getPageNum(),
                selectUserListCondition.getPageSize());

        List<User> userList= userMapperExt.selectList(selectUserListCondition);

        PageInfo<User> userPageInfo = new PageInfo<User>(userList);

        APIResponse<Object> apiResponse = new APIResponse<>();
        apiResponse.setData(userPageInfo);
        apiResponse.setTotal((int) userPageInfo.getTotal());
        apiResponse.setCode(APIResponse.SUCCESS);

        return apiResponse;
    }
}