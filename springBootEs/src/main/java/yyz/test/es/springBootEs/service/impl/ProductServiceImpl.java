package yyz.test.es.springBootEs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import yyz.test.es.springBootEs.service.ProductService;

/**
 * <p>
 *
 * </p>
 *
 * @author yyz
 * @since 2022/3/28
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
}
