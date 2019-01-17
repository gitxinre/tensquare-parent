package com.xinre.base.dao;

import com.xinre.base.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 标签dao
 * JpaRepository 基本的crud
 * JpaSpecificationExecutor 复杂的条件查询
 *
 * @author xinre
 * @date 2019/1/16 17:50
 */
public interface LabelDao extends JpaRepository<Label, String>, JpaSpecificationExecutor<Label> {

}
