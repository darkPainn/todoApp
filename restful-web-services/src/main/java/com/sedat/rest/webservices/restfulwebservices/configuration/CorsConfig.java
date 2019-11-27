package com.sedat.rest.webservices.restfulwebservices.configuration;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Provider
@Configuration
public class CorsConfig implements ContainerResponseFilter {

   @Override
   public void filter(final ContainerRequestContext requestContext,
                      final ContainerResponseContext cres) throws IOException {
      cres.getHeaders().add("Access-Control-Allow-Origin", "*");
      cres.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
   }
   
   @Bean
   public WebMvcConfigurer corsConfigurer() {
       return new WebMvcConfigurerAdapter() {
           @Override
           public void addCorsMappings(CorsRegistry registry) {
               registry.addMapping("/**")
                       .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
           }
       };
   }

}
