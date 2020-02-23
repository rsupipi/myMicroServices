package com.pipi.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component /** @ConfigurationProperties is sufficient to register bean as a component**/
@ConfigurationProperties("limit-service")
@Getter @Setter  /** should be generate getters and setters**/
public class Configuration {
    private int maximum;
    private int minimum;

}
