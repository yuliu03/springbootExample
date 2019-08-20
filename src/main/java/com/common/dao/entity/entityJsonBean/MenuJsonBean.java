package com.common.dao.entity.entityJsonBean;

import com.common.dao.entity.Menu;

import java.util.ArrayList;
import java.util.List;

public class MenuJsonBean extends Menu {
    List<MenuJsonBean> children = new ArrayList<>();

    public List<MenuJsonBean> getChildren() {
        return children;
    }

    public void setChildren(List<MenuJsonBean> children) {
        this.children = children;
    }

    public void append(MenuJsonBean menu){
        children.add(menu);
    }

    public Boolean remove(Menu menu){
        return children.remove(menu);
    }
}
