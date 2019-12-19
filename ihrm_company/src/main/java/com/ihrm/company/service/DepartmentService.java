package com.ihrm.company.service;

import com.ihrm.company.dao.DepartmentDao;
import com.ihrm.domain.company.Department;
import com.ihrm.common.service.BaseService;
import com.ihrm.common.utils.IdWorker;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李靖宇
 * @Project ihrm_parent
 * @date 2019/12/17 9:36
 * @commit 生活明朗，万物可爱，人间值得，未来可期
 */
@Service
public class DepartmentService   extends BaseService {

    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private IdWorker idWorker;

    public void save(Department department){
        department.setId(idWorker.nextId()+"");
        departmentDao.save(department);
    }

    public void update(Department department){
        final Department one = departmentDao.findOne(department.getId());
        BeanUtils.copyProperties(department,one);
        departmentDao.save(one);
    }

    public Department findById(String id){
        return departmentDao.findOne(id);
    }

    public List<Department> findAll(String companyId){
        return departmentDao.findAll(getSpec(companyId));
    }

    public void delete(String id){
        departmentDao.delete(id);
    }
}
