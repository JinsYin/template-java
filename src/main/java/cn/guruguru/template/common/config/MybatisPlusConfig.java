package cn.guruguru.template.common.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// @MapperScan("...")
public class MybatisPlusConfig {

    /**
     * Mybatis-Plus plugins
     *
     * @see <a href="https://baomidou.com/pages/97710a/">MybatisPlusInterceptor</a>
     *
     * @return a {@link MybatisPlusInterceptor}
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // add a pagination plugin that should be placed at the end of other plugins
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return interceptor;
    }
}
