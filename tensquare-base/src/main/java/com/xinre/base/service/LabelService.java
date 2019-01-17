package com.xinre.base.service;

import com.xinre.base.dao.LabelDao;
import com.xinre.base.pojo.Label;
import com.xinre.common.util.IdWorker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * 标签服务
 *
 * @author xinre
 * @date 2019/1/17 17:05
 */
@Service
@Transactional
@Slf4j
public class LabelService {

    @Autowired
    private LabelDao labelDao;
    @Autowired
    private IdWorker idWorker;


    // c
    public void save(Label label) {
        labelDao.save(label);
    }


    // r
    public List<Label> findAll() {
        List<Label> all = labelDao.findAll();
        log.info("标签总数量为：{}", all.size());
        return all;
    }

    public Label findById(String id) {
        log.info("参数id为：{}", id);
        return labelDao.findById(id).get();
    }


    // u
    public void update(Label label) {
        labelDao.save(label);
    }


    // d
    public void deleteById(String id) {
        labelDao.deleteById(id);
    }

}
