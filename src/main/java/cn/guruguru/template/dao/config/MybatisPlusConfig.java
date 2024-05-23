package cn.guruguru.template.dao.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan({ "cn.guruguru.template.dao.mapper" })
public class MybatisPlusConfig { // DaoConfig

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
