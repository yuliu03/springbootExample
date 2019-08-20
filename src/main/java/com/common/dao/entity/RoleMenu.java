package com.common.dao.entity;

public class RoleMenu {
    //UUID
    private String uuid;

    //角色菜单ID
    private String roleMenuId;

    //菜单id
    private String menuId;

    //角色ID
    private String roleId;

    //记录数据创建用户，用于审计，无业务含义，如果是单据，可以作为制单人使用
    private String createdBy;

    //系统保留字段，记录数据创建时间，用于系统审计，无实际业务含义
    private String createdTime;

    //记录数据最后更新用户，用于审计，无业务含义
    private String updatedBy;

    //记录数据最后时间，用于审计，无业务含义
    private String updatedTime;

    //表示当前数据版本，用于控制业务并发，无其它业务含义
    private Integer version;

    //是否删除
    private Integer isDel;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getRoleMenuId() {
        return roleMenuId;
    }

    public void setRoleMenuId(String roleMenuId) {
        this.roleMenuId = roleMenuId == null ? null : roleMenuId.trim();
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime == null ? null : createdTime.trim();
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime == null ? null : updatedTime.trim();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
}