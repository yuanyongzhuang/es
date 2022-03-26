package yyz.test.es.springBootEs.entity.es;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * es blog 实体
 * @author yyz
 */
@Data
@Document(indexName = "blog")
public class EsBlog {

    @Id
    private Integer id;
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String title;
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String author;
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String content;
    @Field(type = FieldType.Date,format = DateFormat.date_hour_minute_second)
    private Date createTime;
    @Field(type = FieldType.Date,format = DateFormat.date_hour_minute_second)
    private Date updateTime;

}
