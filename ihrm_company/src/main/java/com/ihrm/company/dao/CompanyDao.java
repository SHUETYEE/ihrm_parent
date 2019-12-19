package com.ihrm.company.dao;

import com.ihrm.domain.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author 李靖宇
 * @Project ihrm_parent
 * @date 2019/12/16 17:10
 * @commit 生活明朗，万物可爱，人间值得，未来可期
 */
public interface CompanyDao extends JpaRepository<Company,String> , JpaSpecificationExecutor<Company> {

}
