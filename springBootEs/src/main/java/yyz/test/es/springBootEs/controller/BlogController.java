package yyz.test.es.springBootEs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;
import yyz.test.es.springBootEs.entity.es.EsBlog;
import yyz.test.es.springBootEs.service.BlogService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * blog服务
 * @author yyz
 */
@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    BlogService blogService;

    @PostMapping("/saveEs")
    public String saveEs(@RequestBody EsBlog esBlog){
       return blogService.saveEs(esBlog);
    }

    @GetMapping("/getAllEs")
    public String getAllEs(){
        return blogService.getAllEs();
    }

    @GetMapping("queryEsData")
    public Map<String,Object> queryEsData(String title){
        HashMap<String,Object> map = new HashMap<>();
        StopWatch watch = new StopWatch();
        watch.start();
        List<EsBlog> list = blogService.queryEsData(title);
        watch.stop();
        long totalTimeMillis = watch.getTotalTimeMillis();
        System.out.println("========="+totalTimeMillis);
        map.putIfAbsent("duration",totalTimeMillis);
        map.put("list",list);
        return map;
    }

}
