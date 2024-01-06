package com.webAdmin.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id", type = IdType.AUTO)
    private int userId;
    private String userName;
    private String userEmail;
    private String password;
    private String avatar;
    private short userStatus;
    private String salt;
}
