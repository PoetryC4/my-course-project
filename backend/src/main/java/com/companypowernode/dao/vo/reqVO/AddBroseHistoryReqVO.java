package com.companypowernode.dao.vo.reqVO;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liyue
 * @since 2023-09-11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddBroseHistoryReqVO {

    @ApiModelProperty(value = "用户id")
    private Integer userid;

    @ApiModelProperty(value = "历史记录")
    private String history;

    @ApiModelProperty(value = "时间")
    private String date;

}
