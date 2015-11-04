/*
 * Copyright 2015-2025 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package sockslib.common.http;

import java.util.HashMap;
import java.util.Map;

/**
 * The class <code>HttpHeaders</code> represents heads in HTTP message.
 *
 * @author Youchao Feng
 * @version 1.0
 * @date Oct 10,2015 10:41 PM
 */
public class HttpHeaders {

  /**
   * Content length header's name.
   */
  public static final String CONTENT_LENGTH = "Content-Length";

  /**
   * User agent header's name.
   */
  public static final String USER_AGENT = "User-Agent";
  private Map<String, String> headers;

  public HttpHeaders() {
    headers = new HashMap<>();
  }

  public String getHeader(String name) {
    String value = headers.get(name);
    if (value == null) {
      return "";
    } else {
      return value;
    }
  }

  public Map<String, String> getAll() {
    return headers;
  }

  public HttpHeaders setHeader(String name, String value) {
    headers.put(name, value);
    return this;
  }

  public long getContentLength() {
    String value = getHeader(CONTENT_LENGTH);
    try {
      return Long.parseLong(value);
    } catch (NumberFormatException e) {
      return 0;
    }
  }

  public HttpHeaders setContentLength(long contentLength) {
    headers.put(CONTENT_LENGTH, String.valueOf(contentLength));
    return this;
  }

  public String getUserAgent() {
    return getHeader(USER_AGENT);
  }

  public HttpHeaders setUserAgent(String userAgent) {
    headers.put(USER_AGENT, userAgent);
    return this;
  }
}