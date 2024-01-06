package com.companypowernode.dao.vo.reqVO;

/**
 * @author liyue
 * @since 2023/10/5
 */
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class NoticeWebsocketResp<T> {

    @ApiModelProperty(value = "预警类别")
    private String noticeType;

    @ApiModelProperty(value = "预警值")
    private T noticeInfo;

}

