package com.app.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.app.dao.StudentCrud;
import com.app.dao.StudentCrudImp;
import com.app.dao.UserDao;
import com.app.dao.UserDaoImp;
import com.app.servicelayer.StudentService;
import com.app.servicelayer.UserService;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.app.controller")
public class DispatcherConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("/css/");
	}

	@Bean
	public ViewResolver internalviewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Bean
	public DataSource datasource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/studentdb");
		datasource.setUsername("root");
		datasource.setPassword("123456");
		return datasource;
	}

	@Bean
	public UserDao userDao() {
		return new UserDaoImp();
	}

	@Bean
	public UserService userservice() {
		return new UserService();
	}

	@Bean
	public StudentCrud studentcrud() {
		return new StudentCrudImp();
	}

	@Bean
	public StudentService studentservice() {
		return new StudentService();
	}

	@Bean
	public MailSender mailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
		mailSender.setUsername("sharatmaharjan123@gmail.com");
		mailSender.setPassword("123456hellodear");
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		mailSender.setJavaMailProperties(props);
		return mailSender;

	}
}
