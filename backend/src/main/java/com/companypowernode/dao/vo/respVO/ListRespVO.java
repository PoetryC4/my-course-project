package com.companypowernode.dao.vo.respVO;

import lombok.Data;

import java.util.List;


/**
 * @author liyue
 * @since 2023-12-20
 */
@Data
public class ListRespVO<T> {
    private List<T> data;
}
