package com.companypowernode.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * info of an admin
 * </p>
 *
 * @author ly
 * @since 2023-03-21
 */
@TableName("admin_info")
public class AdminInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id2", type = IdType.AUTO)
    private Integer userId2;

    @ApiModelProperty(value = "用户名")
    private String adminName;

    @ApiModelProperty(value = "用户权限")
    private String adminAvater;

    @ApiModelProperty(value = "密码")
    private String adminPassword;

    public Integer getUserId2() {
        return userId2;
    }

    public void setUserId2(Integer userId2) {
        this.userId2 = userId2;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
    public String getAdminAvater() {
        return adminAvater;
    }

    public void setAdminAvater(String adminAvater) {
        this.adminAvater = adminAvater;
    }
    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    @Override
    public String toString() {
        return "AdminInfo{" +
            "userId2=" + userId2 +
            ", adminName=" + adminName +
            ", adminAvater=" + adminAvater +
            ", adminPassword=" + adminPassword +
        "}";
    }
}
