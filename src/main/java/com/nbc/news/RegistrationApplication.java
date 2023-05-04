package com.nbc.news;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nbc.news.config.GlobalProperties;
import com.nbc.news.model.Partner;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Slf4j
@SpringBootApplication
public class RegistrationApplication {
  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  public static void main(String[] args) {
    SpringApplication.run(RegistrationApplication.class, args);
  }

  public Map<String /*partner id*/, Partner> partnerMap(GlobalProperties globalProperties) {
    String partnerPath = globalProperties.getProperties1().get("ROOTPATH").get("rootPartnerPath");
    return Arrays.stream(
            globalProperties
                .getProperties1()
                .get("registration")
                .get("supportedPartners")
                .split(","))
        .map(pid -> new AbstractMap.SimpleEntry<>(pid, createPartner(partnerPath, pid)))
        .collect(Collectors.toMap(SimpleEntry::getKey, SimpleEntry::getValue));
  }

  @SneakyThrows
  private static Partner createPartner(String path, String pid) {
    Resource resource = new ClassPathResource(path + pid + ".json");
    return OBJECT_MAPPER.readValue(resource.getInputStream(), Partner.class);
  }
}
