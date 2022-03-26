package yyz.test.es.springBootEs.entity.mysql;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 *
 * create table t_blog(
 *    id int(11) not null auto_increment comment '自增id',
 *    title varchar(60) default null comment '博客标题',
 *    author varchar(60) default null comment '博客作者',
 *    content mediumtext comment '博客内容',
 *    create_time datetime default null comment '创建时间',
 *    update_time datetime default null comment '更新时间',
 *    primary key (id)
 * ) engine=innodb auto_increment=1 default charset=utf8mb4 comment='es和mysql测试`export_job`';
 * @author yyz
 */
@Data
@TableName("t_blog")
public class MysqlBlog {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String title;
    private String author;
    private String content;
    private Date createTime;
    private Date updateTime;

}
