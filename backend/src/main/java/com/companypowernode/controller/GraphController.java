package com.companypowernode.controller;

import com.companypowernode.dao.vo.baseVO.Result;
import com.companypowernode.dao.vo.reqVO.GraphReqVO;
import com.companypowernode.dao.vo.respVO.GraphRespVO;
import com.companypowernode.service.GraphService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * @author liyue
 * @since 2023-12-18
 */
@Api(tags = "获取图表数据")
@RestController
@RequestMapping("/sys/graph")
public class GraphController {

    @Autowired
    private GraphService graphService;

    @ApiOperation(value = "获取图表数据")
    @PostMapping("/getGraph")
    public Result<Set<GraphRespVO>> getNIncome(@RequestBody GraphReqVO reqVO) throws Exception {
        Set<GraphRespVO> resp = graphService.getNincome(reqVO);
        return Result.success(resp);
    }

//    @ApiOperation(value = "获取流动比率")
//    @PostMapping("/getCurrentRatio")
//    public Result<List<GraphRespVO>> getCurrentRatio(@RequestBody GraphReqVO reqVO) throws Exception {
//        List<GraphRespVO> resp = graphService.getNincome(reqVO);
//        return Result.success(resp);
//    }
}
