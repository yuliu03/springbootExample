package com.common.dao.entity;

import java.math.BigDecimal;

public class Menu {
    //UUID
    private String uuid;

    //功能模块标识，说明此参数适用的功能模块
    private String menuId;

    //父节点ID
    private String pid;

    //模块代码
    private String menuName;

    //用户标识导航树的层次级别，0表示标题、1表示分组、2表示节点、3表示子节点、4表示模块菜单
    private Integer navLevel;

    //菜单对应的Url
    private String fileUrl;

    //是否删除
    private Integer isDel;

    //是否为叶子节点
    private Integer isLeaf;

    //排序码
    private Integer sortCode;

    //version
    private BigDecimal version;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public Integer getNavLevel() {
        return navLevel;
    }

    public void setNavLevel(Integer navLevel) {
        this.navLevel = navLevel;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl == null ? null : fileUrl.trim();
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Integer getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(Integer isLeaf) {
        this.isLeaf = isLeaf;
    }

    public Integer getSortCode() {
        return sortCode;
    }

    public void setSortCode(Integer sortCode) {
        this.sortCode = sortCode;
    }

    public BigDecimal getVersion() {
        return version;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }
}