package com.companypowernode.dao.vo.reqVO;

import com.companypowernode.dao.entity.Alarm;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author liyue
 * @since 2023/10/5
 */
@Data
public class AlarmReqVO {

    private Integer id;
    @ApiModelProperty(value = "笔记标题")
    private String userId;

    @ApiModelProperty(value = "最高价")
    private Float high;

    @ApiModelProperty(value = "最低价")
    private Float low;

    @ApiModelProperty(value = "涨跌额")
    private Float change;


    @ApiModelProperty(value = "股票代码")
    private String tsCode;
}
