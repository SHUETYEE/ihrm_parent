package com.ihrm.company.service;

import com.ihrm.company.dao.CompanyDao;
import com.ihrm.domain.company.Company;
import com.ihrm.common.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李靖宇
 * @Project ihrm_parent
 * @date 2019/12/16 17:17
 * @commit 生活明朗，万物可爱，人间值得，未来可期
 */
@Service
public class CompanyService{

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private IdWorker idWorker;

    public void add(Company company){
        String id = idWorker.nextId() + "";
        company.setId(id);
        company.setAuditState("0");
        company.setState(1);
        companyDao.save(company);
    }

    public void update(Company company){
        final Company one = companyDao.findOne(company.getId());
        one.setName(company.getName());
        companyDao.save(one);
    }

    public void deleteById(String id){
        companyDao.delete(id);
    }

    public Company findById(String id){
        return companyDao.findOne(id);
    }

    public List<Company> findAll(){
        return companyDao.findAll();
    }

}
