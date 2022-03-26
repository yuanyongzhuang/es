package yyz.test.es.springBootEs.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yyz.test.es.springBootEs.entity.es.EsBlog;
import yyz.test.es.springBootEs.entity.mysql.MysqlBlog;
import yyz.test.es.springBootEs.mapper.es.BlogEsRepository;
import yyz.test.es.springBootEs.mapper.mysql.BlogMapper;
import yyz.test.es.springBootEs.service.BlogService;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * mysql blog接口
 * @author yyz
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, MysqlBlog> implements BlogService {

    @Autowired
    BlogEsRepository blogEsRepository;

    @Override
    public String saveEs(EsBlog esBlog) {
        esBlog.setCreateTime(new Date());
        esBlog.setUpdateTime(new Date());

        MysqlBlog mysqlBlog = new MysqlBlog();
        mysqlBlog.setAuthor(esBlog.getAuthor());
        mysqlBlog.setContent(esBlog.getContent());
        mysqlBlog.setCreateTime(esBlog.getCreateTime());
        mysqlBlog.setUpdateTime(esBlog.getUpdateTime());
        mysqlBlog.setTitle(esBlog.getTitle());
        this.save(mysqlBlog);

        esBlog.setId(mysqlBlog.getId());
        blogEsRepository.save(esBlog);

        return mysqlBlog.toString();
    }

    @Override
    public String getAllEs() {
        Iterable<EsBlog> all = blogEsRepository.findAll();
        Iterator<EsBlog> iterator = all.iterator();
        EsBlog next = iterator.next();
        return next.toString();
    }

    @Override
    public List<EsBlog> queryEsData(String title) {
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        boolQueryBuilder.should(QueryBuilders.matchPhraseQuery("title",title));
        boolQueryBuilder.should(QueryBuilders.matchPhraseQuery("content",title));
        String s = boolQueryBuilder.toString();
        System.out.println(s);
        blogEsRepository.search(s);
        return null;
    }
}
