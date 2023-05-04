package com.nbc.news.config;

import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties("registration.configproperties")
public class GlobalProperties {
  private Map<String, Map<String, String>> properties1;
  private Map<String, Map<String, String>> properties2;
}
