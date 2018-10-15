package com.oazofeifa.tcudrake.SpringConfig.General;

import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
public class MVCConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/js/**","/js/","/css/","/css/**")
                .addResourceLocations("/js/**","/js/", "/css/", "/css/**")
                .setCacheControl(CacheControl.noCache());                   //TODO Cambiar a 365 en releaseVersion
    }
}
