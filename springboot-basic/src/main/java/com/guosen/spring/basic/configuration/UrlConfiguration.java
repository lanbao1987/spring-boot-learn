package com.guosen.spring.basic.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "url")
@Getter
@Setter
public class UrlConfiguration {

    private String orderUrl;

    private String shopUrl;
}
