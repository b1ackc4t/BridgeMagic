package bridge.intercept;

import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.annotation.Resource;
import java.nio.charset.Charset;
import java.util.List;

@Component
public class AppWebConfiguration extends WebMvcConfigurationSupport {
    @Autowired
    WebLogIntercept webLogIntercept;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(webLogIntercept).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

}
