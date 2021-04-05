package com.annotation.bean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration  // 作为配置类 替代xml
@ComponentScan(basePackages = {"com.annotation"})
public class SpringConfig {
}
