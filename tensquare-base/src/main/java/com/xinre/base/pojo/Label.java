package com.xinre.base.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 标签实体类
 *
 * @author xinre
 * @date 2019/1/16 17:43
 */

@Data
@Entity
@Table(name = "ts_t_label")
public class Label {

    @Id
    @Column(name = "id_")
    private String id;
    @Column(name = "name_")
    private String name;
    @Column(name = "state_")
    private String state;
    @Column(name = "count_")
    private Long count;
    @Column(name = "fans_")
    private Long fans;
    @Column(name = "recommend_")
    private String recommend;

}
