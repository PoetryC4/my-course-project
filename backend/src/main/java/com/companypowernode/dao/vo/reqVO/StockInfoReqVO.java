package com.companypowernode.dao.vo.reqVO;

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
public class StockInfoReqVO {
    private Integer page;
    private Integer pageSize;
    private String input;
}
