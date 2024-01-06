package com.companypowernode.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.companypowernode.dao.entity.Alarm;
import com.companypowernode.dao.vo.reqVO.AlarmReqVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liyue
 * @since 2023/10/5
 */
@Mapper
public interface AlarmMapper extends BaseMapper<Alarm> {
    void Update(@Param("req") AlarmReqVO reqVO);

    void Insert(@Param("req")AlarmReqVO reqVO);

    List<Alarm> info(@Param("userId") String userId);
}
