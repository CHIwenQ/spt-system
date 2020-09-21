package ziyi.sptsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import ziyi.sptsystem.component.MyLocalResolver;

@Configuration
public class MyMvcConfig  {

    @Bean //国际化 区域解析 bean
    public LocaleResolver localeResolver(){
        return new MyLocalResolver();
    }
}
