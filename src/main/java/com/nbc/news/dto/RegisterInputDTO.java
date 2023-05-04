package com.nbc.news.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Pattern.Flag;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterInputDTO {
  private @NotBlank(message = "The partner id is required") String pid;

  @NotBlank(message = "The email address is required")
  @Email(message = "The email address is invalid", flags = Flag.CASE_INSENSITIVE)
  private String email;

  private String username;

  private @NotBlank(message = "BrandName is required") String brandName;

  @NotBlank(message = "The password is required.")
  @Size(min = 8, max = 100, message = "The password length must be between 2 and 100 characters.")
  @Pattern(regexp = "(.)*(\\d)(.)*", message = "Password field is not following the standards")
  private String password;

  private @NotBlank(message = "The regSource is required.") String regSource;

  private @NotBlank(message = "The authkey is required.") String authKey;

  private boolean rememberMe;
}
