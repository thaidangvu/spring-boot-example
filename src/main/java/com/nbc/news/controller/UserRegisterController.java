package com.nbc.news.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nbc.news.dto.RegisterAPIResponse;
import com.nbc.news.dto.RegisterInputDTO;
import com.nbc.news.model.Partner;
import com.nbc.news.service.PartnerService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/v3")
@RestController
public class UserRegisterController {
  private final PartnerService partnerService;

  @Operation(summary = "Register the user")
  @PostMapping("/registerUser")
  public ResponseEntity<RegisterAPIResponse> registerUser(
      @RequestBody @Valid RegisterInputDTO user) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(
            RegisterAPIResponse.builder()
                .firstName("First")
                .lastName("Last")
                .email("first.last@email.com")
                .accessToken("access-token")
                .build());
  }

  @GetMapping("/partners")
  public List<Partner> getPartners() throws JsonProcessingException {
    return partnerService.getPartners();
  }
}
