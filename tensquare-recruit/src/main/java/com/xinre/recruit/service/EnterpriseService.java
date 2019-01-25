package com.xinre.recruit.service;

import com.xinre.common.util.IdWorker;
import com.xinre.recruit.dao.EnterpriseDao;
import com.xinre.recruit.pojo.Enterprise;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xinre
 * @date 2019/1/18 14:02
 */
@Service
@Transactional
@Slf4j
public class EnterpriseService {

    @Autowired
    private EnterpriseDao enterpriseDao;

    @Autowired
    private IdWorker idWorker;

    public List<Enterprise> findByHot() {
        List<Enterprise> enterpriseByHot = enterpriseDao.findByHot("1");
        log.info("热门企业数量：{}", enterpriseByHot.size());
        return enterpriseByHot;
    }


}
