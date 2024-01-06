package com.companypowernode.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.jeffreyning.mybatisplus.anno.MppMultiId;

import java.io.Serializable;

/**
 * <p>
 * 自选股
 * </p>
 *
 * @author ly
 * @since 2023-03-21
 */
@TableName("user_stock")
public class UserStock implements Serializable {

    private static final long serialVersionUID = 1L;

    @MppMultiId
    @TableField(value = "user_id")
    private String userId;

    @MppMultiId
    @TableField(value = "ts_code")
    private String tsCode;

    private String favorDate;



    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getTsCode() {
        return tsCode;
    }

    public void setTsCode(String tsCode) {
        this.tsCode = tsCode;
    }

    public String getFavorDate() {
        return favorDate;
    }

    public void setFavorDate(String favorDate) {
        this.favorDate = favorDate;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }



    @Override
    public String toString() {
        return "UserStock{" +
                "userId='" + userId + '\'' +
                ", tsCode='" + tsCode + '\'' +
                ", favorDate=" + favorDate +
                '}';
    }
}
