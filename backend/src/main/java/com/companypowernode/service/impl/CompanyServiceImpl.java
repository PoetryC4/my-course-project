package com.companypowernode.service.impl;

import com.companypowernode.dao.entity.Company;
import com.companypowernode.dao.mapper.CompanyMapper;
import com.companypowernode.service.ICompanyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * info of a company 服务实现类
 * </p>
 *
 * @author ly
 * @since 2023-03-21
 */
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements ICompanyService {

}
