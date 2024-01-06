package com.companypowernode.controller;

import com.companypowernode.dao.vo.baseVO.Result;
import com.companypowernode.dao.entity.Company;
import com.companypowernode.service.ICompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * info of a company 前端控制器
 * </p>
 *
 * @author ly
 * @since 2023-03-21
 */
@Api(tags = "公司信息")
@RestController
@RequestMapping("/sys/company")
public class CompanyController {

    @Autowired
    private ICompanyService iCompanyService;

    /**查询公司信息
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "查询公司信息")
    @PostMapping("/get")
    public Result<Company> info(@RequestParam String id){
        Company company = iCompanyService.getById(id);
        return Result.success(company);
    }

}
