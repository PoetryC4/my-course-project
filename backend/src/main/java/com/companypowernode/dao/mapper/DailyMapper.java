package com.companypowernode.dao.mapper;

import com.companypowernode.dao.entity.Daily;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ly
 * @since 2023-03-21
 */
@Mapper
public interface DailyMapper extends BaseMapper<Daily> {

    public List<Daily>getdaily(String tsCode);

}
