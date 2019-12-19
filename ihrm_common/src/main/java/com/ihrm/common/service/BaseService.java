package com.ihrm.common.service;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * @author 李靖宇
 * @Project ihrm_parent
 * @date 2019/12/17 10:47
 * @commit 生活明朗，万物可爱，人间值得，未来可期
 */
public class BaseService<T> {
    protected Specification<T> getSpec(String companyId){
        Specification specification=new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("companyId").as(String.class),companyId);
            }
        };
        return specification;
    }
}
