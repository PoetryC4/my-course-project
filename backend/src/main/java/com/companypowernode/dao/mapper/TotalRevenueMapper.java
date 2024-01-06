package com.companypowernode.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.TreeMap;

@Mapper
public interface TotalRevenueMapper extends BaseMapper<TreeMap<Integer,Double>>{
}
