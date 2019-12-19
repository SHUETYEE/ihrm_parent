package com.ihrm.company;

import com.ihrm.company.dao.CompanyDao;
import com.ihrm.domain.company.Company;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author 李靖宇
 * @Project ihrm_parent
 * @date 2019/12/16 17:12
 * @commit 生活明朗，万物可爱，人间值得，未来可期
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CompanyTest {

    @Autowired
    private CompanyDao companyDao;
    @Test
    public void test1(){
        final List<Company> all = companyDao.findAll();
        System.out.println(all);
    }
}
