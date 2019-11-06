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

import java.util.HashMap;
import java.util.List;
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
        APIResponse apiResponse = new APIResponse();
        return apiResponse;
    }

    public APIResponse selectByPrimaryKey(User record) {
        APIResponse apiResponse = new APIResponse();
        return apiResponse;
    }

    public APIResponse updateByPrimaryKeySelective(User record) {
        APIResponse apiResponse = new APIResponse();
        return apiResponse;
    }

    public APIResponse updateByPrimaryKey(User record) {
        APIResponse apiResponse = new APIResponse();
        return apiResponse;
    }

    public APIResponse selectList(User record) {
        APIResponse apiResponse = new APIResponse();
        List<User> users= userMapperExt.selectList(record);
        return  apiResponse.success(users);
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
}