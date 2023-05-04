package com.nbc.news.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nbc.news.model.Partner;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

@RefreshScope
@Service
public class PartnerServiceImpl implements PartnerService {
  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  private @Value("${supportedPartners}") String supportedPartnerIdsString;
  private @Value("${partners}") String partnersJson;

  @Override
  public List<Partner> getPartners() throws JsonProcessingException {
    var supportedPartnerIds =
        Arrays.stream(supportedPartnerIdsString.split(","))
            .map(Integer::parseInt)
            .collect(Collectors.toUnmodifiableSet());
    return OBJECT_MAPPER.readValue(partnersJson, new TypeReference<List<Partner>>() {}).stream()
        .filter(partner -> supportedPartnerIds.contains(partner.getPid()))
        .toList();
  }
}
