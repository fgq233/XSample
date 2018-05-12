package com.ehcache.sample.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class CacheService {

    @Cacheable(value = "myCache")
    public String getDataFromDb() {
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println("★★★ Ehcache测试：您本次查询了数据库★★★");
        return time;
    }

    @Cacheable(value = "myCache", key = "#param", condition = "#param < 6666666")
    public String getDataFromDb(Integer param) {
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println("★★★ Ehcache测试：您本次查询了数据库★★★");
        return time;
    }


/*
    @Cacheable：  缓存方法返回的结果，下次访问时不再执行方法的代码段
    @Cacheput：   不仅会缓存方法的结果，还会执行方法的代码段，它支持的属性和用法都与@Cacheable一致
    @CacheEvict： 与@Cacheable功能相反，表明所修饰的方法是用来删除失效或无用的缓存

    value：     缓存/清理缓存 的位置名称，在配置文件中定义，不能为空，至少一个
    key：       缓存/清理缓存 的key，可以为空，如果指定要按照 SpEL表达式 编写，如果不指定，则缺省按照方法的所有参数进行组合
    condition： 缓存/清理缓存 的触发条件，可以为空，使用 SpEL表达式 编写，返回 true/false，只有为 true 才执行

@CacheEvict独有：
    allEntries：为true表示清除value中的全部缓存，缺省为false，方法调用后立即清空所有缓存
    beforeInvocation：是否在方法执行前就清空，缺省为false，true则在方法还没有执行的时候就清空缓存
    缺省情况下，如果方法执行抛出异常，则不会清空缓存
*/

}
