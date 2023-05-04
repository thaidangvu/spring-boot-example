package com.nbc.news.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nbc.news.model.Partner;
import java.util.List;

public interface PartnerService {
  List<Partner> getPartners() throws JsonProcessingException;
}
