package com.intrapractice.config;

import javax.sql.DataSource;

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

import com.intrapractice.dao.CategoryDao;
import com.intrapractice.dao.CategoryLikesDao;
import com.intrapractice.dao.EventLikesDao;
import com.intrapractice.dao.EventParticipantsDao;
import com.intrapractice.dao.EventsDao;
import com.intrapractice.dao.UserDao;
import com.intrapractice.dao.impl.CategoryDaoImpl;
import com.intrapractice.dao.impl.CategoryLikesDaoImpl;
import com.intrapractice.dao.impl.EventDaoImpl;
import com.intrapractice.dao.impl.EventLikesDaoImpl;
import com.intrapractice.dao.impl.EventParticipantsDaoImpl;
import com.intrapractice.dao.impl.UserDaoImpl;

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
        dataSource.setUrl("jdbc:mysql://practicesqldb:3306/intrapractice");
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

    @Bean
    public EventParticipantsDao getEventsParticipantsDao() {
    	return new EventParticipantsDaoImpl();
    }

    @Bean
    public EventLikesDao getEventLikesDao() {
    	return new EventLikesDaoImpl();
    }

    @Bean
    public CategoryDao getCategoryDao() {
    	return new CategoryDaoImpl();
    }

    @Bean
    public CategoryLikesDao getCategoryLikesDao() {
    	return new CategoryLikesDaoImpl();
    }


}
