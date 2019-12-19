package com.ihrm.system.dao;

import com.ihrm.domain.system.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author 李靖宇
 * @Project ihrm_parent
 * @date 2019/12/17 14:11
 * @commit 生活明朗，万物可爱，人间值得，未来可期
 */
public interface UserDao extends JpaRepository<User,String>, JpaSpecificationExecutor<User> {
    User findByMobile(String mobile);
}
