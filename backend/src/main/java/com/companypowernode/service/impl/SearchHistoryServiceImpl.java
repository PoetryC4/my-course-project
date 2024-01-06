package com.companypowernode.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.companypowernode.dao.entity.SearchHistory;
import com.companypowernode.dao.mapper.SearchHistoryMapper;
import com.companypowernode.service.ISearchHistoryService;
import org.springframework.stereotype.Service;

@Service
public class SearchHistoryServiceImpl extends ServiceImpl<SearchHistoryMapper, SearchHistory> implements ISearchHistoryService{
}
