package com.companypowernode.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author liyue
 * @since 2023-9-17
 */
@Data
@TableName("alarm")
public class Alarm implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String userId;

    private Float high;


    private Float low;

    @TableField(value = "`change`")
    private Float change;

    private String tsCode;

//    public Alarm(String userId,String tsCode){
//
//        this.userId = userId;
//        this.tsCode = tsCode;
//    }
//    public Alarm(Integer id,String userId,String high,String low,String change,String tsCode){
//        this.id = id;
//        this.high = high;
//        this.low = low;
//        this.change = change;
//        this.userId = userId;
//        this.tsCode = tsCode;
//    }

}
