package com.companypowernode.service.impl;

import com.companypowernode.dao.entity.MyNotes;
import com.companypowernode.dao.mapper.MyNotesMapper;
import com.companypowernode.service.IMyNotesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 我的笔记 服务实现类
 * </p>
 *
 * @author ly
 * @since 2023-03-21
 */
@Service
public class MyNotesServiceImpl extends ServiceImpl<MyNotesMapper, MyNotes> implements IMyNotesService {
}
