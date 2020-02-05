package com.common.dao.entity;

import com.common.dao.baseDomain.Domain;
import java.math.BigDecimal;
import java.util.Date;

public class RoleMenu extends Domain {
    private String uuid;

    private String roleId;

    private String menuRoleId;

    private String menuRoleName;

    private String createdBy;

    private Date updatedTime;

    private String updatedBy;

    private Date createdTime;

    private String remark;

    private BigDecimal version;

    private Byte isDel;

    private String menuId;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getMenuRoleId() {
        return menuRoleId;
    }

    public void setMenuRoleId(String menuRoleId) {
        this.menuRoleId = menuRoleId == null ? null : menuRoleId.trim();
    }

    public String getMenuRoleName() {
        return menuRoleName;
    }

    public void setMenuRoleName(String menuRoleName) {
        this.menuRoleName = menuRoleName == null ? null : menuRoleName.trim();
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public BigDecimal getVersion() {
        return version;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }

    public Byte getIsDel() {
        return isDel;
    }

    public void setIsDel(Byte isDel) {
        this.isDel = isDel;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }
}