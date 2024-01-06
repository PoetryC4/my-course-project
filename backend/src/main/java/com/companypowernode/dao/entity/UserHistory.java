package com.companypowernode.dao.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 浏览历史
 * </p>
 *
 * @author ly
 * @since 2023-03-21
 */
@TableName("user_history")
public class UserHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id")
    private String userId;


    private String tsCode;


    private String browseDate;

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

    public String getBrowseDate() {
        return browseDate;
    }

    public void setBrowseDate(String browseDate) {
        this.browseDate = browseDate;
    }

    @Override
    public String toString() {
        return "UserHistory{" +
            "userId=" + userId +
            ", tsCode=" + tsCode +
            ", browseDate=" + browseDate +
        "}";
    }
}
