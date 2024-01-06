package com.companypowernode.dao.vo.respVO;

import com.companypowernode.dao.entity.FinalIndicator;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author liyue
 * @since 2023/10/24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RevenueRespVO {
    @ApiModelProperty(value = "每股营业收入")
    private List<FinalIndicator> list;
}
