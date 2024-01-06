package com.companypowernode.dao.vo.reqVO;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liyue
 * @since 2023-12-18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GraphReqVO {
    @ApiModelProperty(value = "股票代码")
    public String tsCode;
//    @ApiModelProperty(value = "公告开始日期")
//    public String startDate;
//    @ApiModelProperty(value = "公告结束日期")
//    public String endDate;
    @ApiModelProperty(value = "图表字段")
    public String field;
    @ApiModelProperty(value = "图表类型")
    public String graphType;
    @ApiModelProperty(value = "1代表一季度，2代表中报，3代表三季度，4代表年报")
    private String endType;
}
