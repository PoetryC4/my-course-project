package com.companypowernode.dao.vo.reqVO;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liyue
 * @since 2023/10/24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RevenueReqVO {
    @ApiModelProperty(value = "开始时间")
    private String startTime;
    @ApiModelProperty(value = "结束时间")
    private String endTime;
}
