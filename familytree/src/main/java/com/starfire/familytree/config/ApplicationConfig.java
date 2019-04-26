package com.starfire.familytree.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@SpringBootConfiguration
@EnableAutoConfiguration
@MapperScan({"com.starfire.familytree.*.mapper","com.starfire.familytree.mapper","com.starfire.familytree.security.mapper"})
public class ApplicationConfig {

	  @Bean(name = "applicationEventMulticaster")
	    public ApplicationEventMulticaster simpleApplicationEventMulticaster() {
	        SimpleApplicationEventMulticaster eventMulticaster 
	          = new SimpleApplicationEventMulticaster();
	         
	        eventMulticaster.setTaskExecutor(new SimpleAsyncTaskExecutor());
	        return eventMulticaster;
	    }
	  @Bean
	    public CommonsRequestLoggingFilter logFilter() {
	        CommonsRequestLoggingFilter filter
	          = new CommonsRequestLoggingFilter();
	        filter.setIncludeQueryString(true);
	        filter.setIncludePayload(true);
	        filter.setMaxPayloadLength(10000);
	        filter.setIncludeHeaders(false);
	        filter.setAfterMessagePrefix("REQUEST DATA : ");
	        return filter;
	    }
	  
	  @Bean
	  public RestTemplate rt() {
		  return new RestTemplate();
	  }
	  
	  @Bean
	    public OAuth2RestTemplate ort(OAuth2ProtectedResourceDetails details) {
	      OAuth2RestTemplate oAuth2RestTemplate = new OAuth2RestTemplate(details);
	      return oAuth2RestTemplate;
	    }
}
