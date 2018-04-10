package com.cupcodeteam.cupcode.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by YusReE_MS on 4/3/2018.
 */
@Configuration
public class StaticResourceConfig extends WebMvcConfigurerAdapter {

    String path = "F:\\Cupcode";

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){

//        registry.addResourceHandler("New/**")
//                .addResourceLocations("file:F:\\New\\");

        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:static/");

        registry.addResourceHandler("Cupcode/**")
                .addResourceLocations("file:" + this.path +"/");
    }
}
