package yyz.test.es.springBootEs.mapper.es;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import yyz.test.es.springBootEs.entity.es.EsBlog;

/**
 * es
 * @author yyz
 */
public interface BlogEsRepository extends ElasticsearchRepository<EsBlog,Integer> {
}
