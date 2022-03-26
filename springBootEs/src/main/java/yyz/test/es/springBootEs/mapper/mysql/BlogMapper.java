package yyz.test.es.springBootEs.mapper.mysql;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import yyz.test.es.springBootEs.entity.mysql.MysqlBlog;

/**
 * mysqlBlog  数据库存储验证
 * @author yyz
 */

@Mapper
public interface BlogMapper extends BaseMapper<MysqlBlog> {
}
