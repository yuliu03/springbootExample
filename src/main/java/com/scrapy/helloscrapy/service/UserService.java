package com.scrapy.helloscrapy.service;
import com.common.dao.entity.User;
import com.common.dao.entity.entityJsonBean.SessionUserJsonBean;
import com.scrapy.helloscrapy.common.APIResponse;
import java.util.List;

public interface UserService {
    APIResponse deleteByPrimaryKey(User record);

    APIResponse insert(User record);

    APIResponse selectByPrimaryKey(User record);

    APIResponse updateByPrimaryKeySelective(User record);

    APIResponse updateByPrimaryKey(User record);

    APIResponse selectList(User record);

    APIResponse login(User user);

    void logout(SessionUserJsonBean sessionUserJsonBean);
}