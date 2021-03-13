package com.example.AirportApp.Controllers;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.templateresource.SpringResourceTemplateResource;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@Configuration
//@EnableWebMvc
@ComponentScan
public class ConfigClass {

   private final WebApplicationContext webApplicationContext;

    @Autowired
    public ConfigClass(WebApplicationContext webApplicationContext) {
        this.webApplicationContext = webApplicationContext;
    }

    @Bean
    public SpringResourceTemplateResolver getTemplateResolver(){
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(this.webApplicationContext);
        templateResolver.setSuffix(".html");
        templateResolver.setPrefix("classpath:/templates/");
        templateResolver.setCacheable(true);
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine(){
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(getTemplateResolver());
        templateEngine.setEnableSpringELCompiler(false);
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver thymeleafViewResolver(){
        ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
        thymeleafViewResolver.setTemplateEngine(templateEngine());
        thymeleafViewResolver.setViewNames(new String[]{"index","verify","register","plane-info-list","list-user-flights","list-admin-flights","flight-passengers","buy_ticket",".css"});
        thymeleafViewResolver.setExcludedViewNames(new String[]{"*.jsp"});
        thymeleafViewResolver.setAlwaysProcessRedirectAndForward(true);

        return thymeleafViewResolver;
    }


}
