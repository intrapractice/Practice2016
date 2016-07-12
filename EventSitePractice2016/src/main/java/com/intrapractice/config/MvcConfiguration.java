package com.intrapractice.config;

import javax.sql.DataSource;

import com.intrapractice.dao.EventsDao;
import com.intrapractice.dao.UserDao;
import com.intrapractice.dao.impl.EventDaoImpl;
import com.intrapractice.dao.impl.UserDaoImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages="com.intrapractice")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter{

	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://10.11.11.104:3306/intrapractice");
        dataSource.setUsername("intrapractice");
        dataSource.setPassword("Ecp123ecp!");
         
        return dataSource;
    }
	
	
	@Bean
    public JdbcTemplate jdbcTemplate() {    
        final JdbcTemplate jdbcTemplate = new JdbcTemplate();

        jdbcTemplate.setDataSource(getDataSource());
        jdbcTemplate.afterPropertiesSet();

        return jdbcTemplate;
    }

	@Bean
    public UserDao getUserDAO() {
        return new UserDaoImpl();
    }
    
    @Bean
    public EventsDao getEventsDAO(){
    	return new EventDaoImpl();
    
    }
    
    
    
}
