package com.nbc.news.util;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.pattern.CompositeConverter;
import org.springframework.web.util.HtmlUtils;

public class CustomCRLFConverter extends CompositeConverter<ILoggingEvent> {
  @Override
  protected String transform(ILoggingEvent iLoggingEvent, String s) {
    var string = s.replace('\n', '_').replace('\r', '_');
    return HtmlUtils.htmlEscape(string);
  }
}
