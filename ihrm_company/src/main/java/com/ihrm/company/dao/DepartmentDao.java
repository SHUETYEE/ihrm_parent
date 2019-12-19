package com.ihrm.company.dao;

import com.ihrm.domain.company.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author 李靖宇
 * @Project ihrm_parent
 * @date 2019/12/17 9:35
 * @commit 生活明朗，万物可爱，人间值得，未来可期
 */
public interface DepartmentDao extends JpaRepository<Department,String>, JpaSpecificationExecutor<Department> {

}
