package com.companypowernode.dao.vo.respVO;

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
public class GraphRespVO {

    @ApiModelProperty(value = "公告日期")
    public String endDate;
    @ApiModelProperty(value = "参数结果")
    public String data;


}
