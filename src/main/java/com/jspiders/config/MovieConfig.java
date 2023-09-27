package com.jspiders.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.jspiders","com.jspiders.config","com.jspiders.controller","com.jspiders.entity","com.jspiders.repository","com.jspiders.service"})
public class MovieConfig {

}
