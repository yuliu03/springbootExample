package com.scrapy.helloscrapy.service.impl;
import com.common.dao.entity.Menu;
import com.common.dao.entity.entityJsonBean.MenuJsonBean;
import com.common.dao.mapper.MenuMapperExt;
import com.scrapy.helloscrapy.common.APIResponse;
import com.scrapy.helloscrapy.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
class MenuServiceImpl implements MenuService {
    @Autowired
    public MenuMapperExt menuMapperExt;

    public APIResponse deleteByPrimaryKey(Menu record) {
        APIResponse apiResponse = new APIResponse();
        return apiResponse;
    }

    public APIResponse insert(Menu record) {
        APIResponse apiResponse = new APIResponse();
        return apiResponse;
    }

    public APIResponse selectByPrimaryKey(Menu record) {
        APIResponse apiResponse = new APIResponse();
        return apiResponse;
    }

    public APIResponse updateByPrimaryKeySelective(Menu record) {
        APIResponse apiResponse = new APIResponse();
        return apiResponse;
    }

    public APIResponse updateByPrimaryKey(Menu record) {
        APIResponse apiResponse = new APIResponse();
        return apiResponse;
    }

    public APIResponse selectList(Menu record) {
        APIResponse apiResponse = new APIResponse();
        List<MenuJsonBean> menuJsonBeanList = new ArrayList<MenuJsonBean>();
        MenuJsonBean subMenuListCondition = new MenuJsonBean();
        //////
        //如果为空，返回所有菜单
        if (record == null){
            //设置条件
            subMenuListCondition.setPid("0");
            //递归获取子集菜单
            getSubMenuList(menuJsonBeanList,subMenuListCondition);
            apiResponse.setData(menuJsonBeanList);
        }
        //如果不为空，返回所有子集菜单
        else{
            //设置条件
            subMenuListCondition.setPid(record.getUuid());
            //递归获取子集菜单
            getSubMenuList(menuJsonBeanList,subMenuListCondition);

            //把父菜加入到返回值，并且保持返回数据类型一致
            MenuJsonBean menuJsonBean = (MenuJsonBean) record;
            menuJsonBean.setChildren(menuJsonBeanList);
            ArrayList<MenuJsonBean> menuJsonBeanListExt = new ArrayList<MenuJsonBean>();
            menuJsonBeanListExt.add(menuJsonBean);

            apiResponse.setData(menuJsonBeanListExt);//把获取到的子集放入父级对象中
        }

        apiResponse.setCode(APIResponse.SUCCESS);
        return apiResponse;
    }

    private void getSubMenuList( List<MenuJsonBean> menuJsonBeanList,MenuJsonBean subMenuListCondition) {
        List<MenuJsonBean> list = menuMapperExt.selectList(subMenuListCondition); //获取所有下一集级菜单
        for (Menu menu : list){
//            MenuJsonBean menuJsonBean = new MenuJsonBean();
//            menuJsonBean.setPid(menu.getUuid());
            MenuJsonBean menuJsonBean = (MenuJsonBean)menu;
            menuJsonBeanList.add(auxSubMenuList(menuJsonBean));
        }
    }

    private MenuJsonBean auxSubMenuList(MenuJsonBean record){
            if (record.getIsLeaf()==1){
                return record;
            }else {
                MenuJsonBean subMenuListCondition = new MenuJsonBean();
                subMenuListCondition.setPid(record.getUuid());
                List<MenuJsonBean> children = menuMapperExt.selectList(subMenuListCondition);
                for (Menu menu: children){
                    MenuJsonBean menuJsonBean = (MenuJsonBean) menu;
                    record.append(auxSubMenuList(menuJsonBean));
                }
                return record;
            }

    }
}