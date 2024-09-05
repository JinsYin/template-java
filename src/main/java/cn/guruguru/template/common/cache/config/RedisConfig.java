package cn.guruguru.template.common.cache.config;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Redis configuration
 *
 * @see RedisAutoConfiguration
 * @see org.springframework.boot.autoconfigure.data.redis.RedisProperties
 */
@Configuration
@EnableCaching
@EnableTransactionManagement
@AutoConfigureBefore(RedisAutoConfiguration.class)
@ComponentScan(basePackages = { "cn.guruguru.template.common.cache.service" })
public class RedisConfig {
//    @Bean
//    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
//        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(redisConnectionFactory);
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setValueSerializer(new StringRedisSerializer());
//        return redisTemplate;
//    }
}
