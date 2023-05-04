package com.nbc.news.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterAPIResponse {
  private @JsonProperty("first_name") String firstName;
  private @JsonProperty("last_name") String lastName;
  private String email;
  private @JsonProperty("user_name") String userName;
  private @JsonProperty("payload_token") String payloadToken;
  private @JsonProperty("token_time") String tokenTime;
  private @JsonProperty("provider_uid") String providerUid;
  private @JsonProperty("access_token") String accessToken;
  private @JsonProperty("app_access") String appAccess;
  private @JsonProperty("tinypass_token") String tinypassToken;
  private @JsonProperty("session_token") String sessionToken;
  private Boolean isTempPassword;
  private String testConfig;
}
