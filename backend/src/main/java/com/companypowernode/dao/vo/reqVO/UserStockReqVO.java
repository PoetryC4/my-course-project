package com.companypowernode.dao.vo.reqVO;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liyue
 * @since 2023-9-13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserStockReqVO {

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "股票代码")
    private String tsCode;

    @ApiModelProperty(value = "自选股选中日期")
    private String favorDate;

    private Integer page;

    private Integer pageSize;
}
