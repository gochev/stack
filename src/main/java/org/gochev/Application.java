package org.gochev;
import org.gochev.domain.User;
import org.gochev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
@EnableAutoConfiguration
@Configuration
@ComponentScan
@EnableJpaAuditing
public class Application extends RepositoryRestMvcConfiguration {
	
	@Autowired
	private ApplicationContext applicationContext;
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		UserRepository userRepo = context.getBean(UserRepository.class);
		User user = new User();
		user.setEmail("test@test.com");
		user.setFullName("test4o testov");
		
		userRepo.save(user);
		
		System.out.println(userRepo.findOne(1L).getCreatedDate());
		System.out.println(userRepo.findOne(1L).getCreatedBy());
	}
	
	@Bean
    public UrlBasedViewResolver setupViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }
	

}
