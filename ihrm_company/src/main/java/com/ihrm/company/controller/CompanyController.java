package com.ihrm.company.controller;

import com.ihrm.company.service.CompanyService;
import com.ihrm.domain.company.Company;
import com.ihrm.common.entity.Result;
import com.ihrm.common.entity.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 李靖宇
 * @Project ihrm_parent
 * @date 2019/12/16 17:29
 * @commit 生活明朗，万物可爱，人间值得，未来可期
 */
@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping
    public Result save(@RequestBody Company company){
        companyService.add(company);
        return new Result(ResultCode.SUCCESS);
    }

    @PutMapping("/{id}")
    public Result update(@RequestBody Company company,@PathVariable("id") String id){
        company.setId(id);
        companyService.update(company);
        return new Result(ResultCode.SUCCESS);
    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable("id") String id){
        final Company company = companyService.findById(id);
        Result result = new Result(ResultCode.SUCCESS);
        result.setData(company);
        return result;
    }

    @GetMapping
    public Result findAll(){
        List<Company> companyList = companyService.findAll();
        Result result = new Result(ResultCode.SUCCESS);
        result.setData(companyList);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") String id){
        companyService.deleteById(id);
        return new Result(ResultCode.SUCCESS);
    }

}
