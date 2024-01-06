package com.companypowernode.dao.vo.reqVO;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liyue
 * @since 2023-12-09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginVO {
    @ApiModelProperty(value = "邮箱")
    private String userEmail;
    @ApiModelProperty(value = "密码")
    private String password;
}
