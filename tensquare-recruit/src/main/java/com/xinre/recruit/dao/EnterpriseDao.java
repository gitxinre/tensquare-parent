package com.xinre.recruit.dao;

import com.xinre.recruit.pojo.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author xinre
 * @date 2019/1/18 13:57
 */
public interface EnterpriseDao extends JpaRepository<Enterprise, String>, JpaSpecificationExecutor<Enterprise> {


    /**
     * 获取热门企业
     *
     * @param hot 是否热门
     * @return 企业列表
     */
    List<Enterprise> findByHot(String hot);
}
