/*******************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one
 *        or more contributor license agreements.  See the NOTICE file
 *        distributed with this work for additional information
 *        regarding copyright ownership.  The ASF licenses this file
 *        to you under the Apache License, Version 2.0 (the
 *        "License"); you may not use this file except in compliance
 *        with the License.  You may obtain a copy of the License at
 * 
 *          http://www.apache.org/licenses/LICENSE-2.0
 * 
 *        Unless required by applicable law or agreed to in writing,
 *        software distributed under the License is distributed on an
 *        "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *        KIND, either express or implied.  See the License for the
 *        specific language governing permissions and limitations
 *        under the License.
 ******************************************************************************/
package org.apache.olingo.odata2.core.debug;

import java.io.IOException;
import java.util.Map;

import org.apache.olingo.odata2.api.commons.HttpStatusCodes;
import org.apache.olingo.odata2.core.ep.util.JsonStreamWriter;

/**
 * @author SAP AG
 */
public class DebugInfoResponse implements DebugInfo {

  private final HttpStatusCodes status;
  private final Map<String, String> headers;

  public DebugInfoResponse(final HttpStatusCodes status, final Map<String, String> headers) {
    this.status = status;
    this.headers = headers;
  }

  @Override
  public String getName() {
    return "Response";
  }

  @Override
  public void appendJson(final JsonStreamWriter jsonStreamWriter) throws IOException {
    jsonStreamWriter.beginObject();

    if (status != null) {
      jsonStreamWriter.name("status")
          .beginObject()
          .name("code").unquotedValue(Integer.toString(status.getStatusCode())).separator()
          .namedStringValueRaw("info", status.getInfo())
          .endObject();
    }

    if (!headers.isEmpty()) {
      if (status != null) {
        jsonStreamWriter.separator();
      }

      jsonStreamWriter.name("headers")
          .beginObject();
      boolean first = true;
      for (final String name : headers.keySet()) {
        if (!first) {
          jsonStreamWriter.separator();
        }
        first = false;
        jsonStreamWriter.namedStringValue(name, headers.get(name));
      }
      jsonStreamWriter.endObject();
    }

    jsonStreamWriter.endObject();
  }
}
