CREATE TABLE tb_label(id_ VARCHAR(64),
                      label_name_ VARCHAR(255),
                      state_ CHAR COMMENT '0:无效  1:有效',
                      count_ INT(10),
                      fans_ INT(10),
                      recommend_ CHAR COMMENT '0:不推荐  1:推荐');