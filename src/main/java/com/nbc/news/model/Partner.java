package com.nbc.news.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Partner {
  @Getter
  @Setter
  public static class Attributes {
    private @JsonProperty("SESSION_VAL_REQ") boolean sessionValReq;
    private @JsonProperty("SESSION_FACTORY") String sessionFactory;
    private @JsonProperty("REMEMBER_ME_TTL_MILLIS") int rememberMeTtlMillis;
    private @JsonProperty("DEFAULT_TTL_MILLIS") int defaultTtlMillis;
    private @JsonProperty("PLATFORM_NAME") String platformName;
    private @JsonProperty("CAPTCHA_VAL_REQ") Boolean captchaValReq;
  }

  @Getter
  @Setter
  public static class RestEndPoint {
    private String request;
    private Attributes attributes;
  }

  private int pid;
  private String name;
  private String authServiceName;
  private List<RestEndPoint> restEndPoints;
}
