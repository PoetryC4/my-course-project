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
@AllArgsConstructor
@NoArgsConstructor
public class NewsReqVO {

    @ApiModelProperty(value = "新闻id")
    private String newsId;

    private Integer page;

    private Integer pageSize;

    private String input;
}
