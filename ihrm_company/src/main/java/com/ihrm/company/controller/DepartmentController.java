package com.ihrm.company.controller;

import com.ihrm.company.service.CompanyService;
import com.ihrm.company.service.DepartmentService;
import com.ihrm.domain.company.Company;
import com.ihrm.domain.company.Department;
import com.ihrm.domain.company.response.DeptListResult;
import com.ihrm.common.controller.BaseController;
import com.ihrm.common.entity.Result;
import com.ihrm.common.entity.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 李靖宇
 * @Project ihrm_parent
 * @date 2019/12/17 9:46
 * @commit 生活明朗，万物可爱，人间值得，未来可期
 */
@CrossOrigin
@RestController
@RequestMapping("/company")
public class DepartmentController extends BaseController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private CompanyService companyService;

    @PostMapping("/department")
    public Result save(@RequestBody Department department){
        department.setCompanyId(companyId);
        departmentService.save(department);
        return new Result(ResultCode.SUCCESS);
    }

    @DeleteMapping("/department/{id}")
    public Result delete(@PathVariable("id") String id){
        departmentService.delete(id);
        return new Result(ResultCode.SUCCESS);
    }

    @GetMapping("/department")
    public Result findAll(){
        Company company = companyService.findById(companyId);
        List<Department> departments = departmentService.findAll(companyId);
        DeptListResult deptListResult = new DeptListResult(company,departments);
        return new Result(ResultCode.SUCCESS,deptListResult);
    }

    @GetMapping("/department/{id}")
    public Result findById(@PathVariable("id")String id){
        Department department = departmentService.findById(id);
        return new Result(ResultCode.SUCCESS,department);
    }

    @PutMapping("/department/{id}")
    public Result update(@PathVariable("id") String id,@RequestBody Department department){
        department.setId(id);
        departmentService.update(department);
        return new Result(ResultCode.SUCCESS);
    }
}
