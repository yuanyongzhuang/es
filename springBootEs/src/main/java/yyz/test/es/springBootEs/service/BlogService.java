package yyz.test.es.springBootEs.service;

import com.baomidou.mybatisplus.extension.service.IService;
import yyz.test.es.springBootEs.entity.es.EsBlog;
import yyz.test.es.springBootEs.entity.mysql.MysqlBlog;

import java.util.List;

/**
 * @author yyz
 */
public interface BlogService extends IService<MysqlBlog> {
    String saveEs(EsBlog esBlog);

    String getAllEs();

    List<EsBlog> queryEsData(String title);
}
