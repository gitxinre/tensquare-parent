package com.xinre.recruit.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author xinre
 * @date 2019/1/18 13:43
 */
@Data
@Entity
@Table(name = "ts_t_enterprise")
public class Enterprise {

    @Id
    @Column(name = "id_")
    private String id;
    @Column(name = "name_")
    private String name;
    @Column(name = "summary_")
    private String summary;
    @Column(name = "address_")
    private String address;
    @Column(name = "labels_")
    private String labels;
    @Column(name = "coordinate_")
    private String coordinate;
    @Column(name = "hot_")
    private String hot;
    @Column(name = "logo_")
    private String logo;
    @Column(name = "job_count_")
    private String jobCount;
    @Column(name = "url_")
    private String url;


}
