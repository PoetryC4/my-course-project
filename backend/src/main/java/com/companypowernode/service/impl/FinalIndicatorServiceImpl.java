package com.companypowernode.service.impl;


import com.companypowernode.dao.entity.FinalIndicator;
import com.companypowernode.dao.mapper.FinalIndicatorMapper;
import com.companypowernode.service.IFinalIndicatorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ly
 * @since 2023-03-21
 */
@Service
public class FinalIndicatorServiceImpl extends ServiceImpl<FinalIndicatorMapper, FinalIndicator> implements IFinalIndicatorService {

//    @Override
//    public List getadd(String tscode) {
//        String windowPath = ClassUtils.getDefaultClassLoader().getResource("").getPath().substring(1)+("py/");
//        Process process = new ProcessBuilder("cmd.exe","/c","python",windowPath);
//        return null;
//    }
}
