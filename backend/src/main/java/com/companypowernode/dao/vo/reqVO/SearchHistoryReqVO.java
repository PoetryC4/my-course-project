package com.companypowernode.dao.vo.reqVO;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liyue
 * @since 2023-9-12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchHistoryReqVO {
    private Integer page;

    private Integer pageSize;

    private String input;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "浏览历史id")
    private Integer sId;

    @ApiModelProperty(value = "股票代码")
    private String tsCode;

    @ApiModelProperty(value = "股票名称")
    private String tsName;

    @ApiModelProperty(value = "历史日期")
    private String sDate;
}
