package world.zmxl.demo.app.config;

import cn.hutool.core.util.StrUtil;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 类的介绍
 *
 * @author 醉梦仙露
 * @date 2023/10/28
 */
@Configuration
public class BaseJedisConfiguration {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private Integer port;

    @Value("${spring.redis.username}")
    private String username;

    @Value("${spring.redis.password}")
    private String password;

    @Bean(value = "baseRedissonClient", destroyMethod = "shutdown")
    public RedissonClient initRedissonClient() {
        Config config = new Config();
        config.setCodec(JsonJacksonCodec.INSTANCE)
                .useSingleServer()
                .setAddress(StrUtil.format("redis://{}:{}", host, port))
                .setUsername(username)
                .setPassword(password)
                .setConnectionMinimumIdleSize(10);
        return Redisson.create(config);
    }

}
