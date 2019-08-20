package com.common.dao.entity;

public class RoleUser {
    //UUID
    private String uuid;

    //角色模块ID
    private String roleUserId;

    //ID
    private String userId;

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

    public String getRoleUserId() {
        return roleUserId;
    }

    public void setRoleUserId(String roleUserId) {
        this.roleUserId = roleUserId == null ? null : roleUserId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
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