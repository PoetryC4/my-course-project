package com.companypowernode.dao.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * info of a user
 * </p>
 *
 * @author ly
 * @since 2023-03-21
 */
@Data
@TableName("user_info")
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "user_id")
    private String userId;

    private String tsCode;

    private String userName;

    private String userEmail;

    private String password;

    private String gender;

    private String avatar;

    private Boolean isEnabled;

    private Integer isOpenAlarm;

    private String phone;

}
