package com.companypowernode.dao.vo.reqVO;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liyue
 * @since 2023-9-11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyNoteReqVO {

    @ApiModelProperty(value = "笔记id")
    private String noteId;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "笔记标题")
    private String title;

    @ApiModelProperty(value = "笔记记录日期")
    private String noteDate;

    @ApiModelProperty(value = "笔记内容")
    private String content;

    private Integer page;

    private Integer pageSize;

    @ApiModelProperty(value = "输入")
    private String input;
}
