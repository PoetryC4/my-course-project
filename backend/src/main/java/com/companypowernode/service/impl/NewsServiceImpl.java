package com.companypowernode.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.companypowernode.dao.entity.News;
import com.companypowernode.dao.mapper.NewsMapper;
import com.companypowernode.service.INewsService;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements INewsService {
}
