package springboot.test_springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springboot.test_springboot.interceptor.AuthorizationInterceptor;
//@ComponentScan(basePackages={"springboot.test_springboot.config"})
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
	@Autowired
	private AuthorizationInterceptor authorizationInterceptor;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/**").excludePathPatterns("/user/login","/user/addUser");
        
		
	}

}
