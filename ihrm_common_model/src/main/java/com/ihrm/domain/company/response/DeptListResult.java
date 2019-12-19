package com.ihrm.domain.company.response;

import com.ihrm.domain.company.Company;
import com.ihrm.domain.company.Department;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 李靖宇
 * @Project ihrm_parent
 * @date 2019/12/17 10:05
 * @commit 生活明朗，万物可爱，人间值得，未来可期
 */
@Data
@NoArgsConstructor
public class DeptListResult {
    private String companyId;
    private String companyName;
    private String companyManage;
    private List<Department> depts;

    public DeptListResult(Company company, List depts) {
        this.companyId=company.getId();
        this.companyName=company.getName();
        this.companyManage=company.getLegalRepresentative();
        this.depts=depts;
    }
}
