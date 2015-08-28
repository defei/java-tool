package org.codelogger.tool;

import static com.google.common.collect.Maps.newHashMap;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.codelogger.web.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "request", produces = "application/json")
public class RequestController extends BaseController {

  @RequestMapping(value = "headers")
  public Object getHeaders(final HttpServletRequest request) {

    @SuppressWarnings("unchecked")
    Enumeration<String> headerNames = request.getHeaderNames();
    Map<String, String> headers = newHashMap();
    while (headerNames.hasMoreElements()) {
      String key = headerNames.nextElement();
      String value = request.getHeader(key);
      headers.put(key, value);
    }
    return headers;
  }

  @RequestMapping(value = "parameters")
  public Object postTickets(final HttpServletRequest request) {

    return request.getParameterMap();
  }

}
