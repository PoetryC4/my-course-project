package com.companypowernode.service;

import com.companypowernode.dao.vo.reqVO.GraphReqVO;
import com.companypowernode.dao.vo.respVO.GraphRespVO;

import java.util.List;
import java.util.Set;

/**
 * @author liyue
 * @since 2023-12-18
 */
public interface GraphService {
    Set<GraphRespVO> getNincome(GraphReqVO reqVO) throws Exception;


}
