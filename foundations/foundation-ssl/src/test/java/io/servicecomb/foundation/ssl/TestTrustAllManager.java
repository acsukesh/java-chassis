/*
 * Copyright 2017 Huawei Technologies Co., Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.servicecomb.foundation.ssl;

import java.net.Socket;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLEngine;

import org.junit.Assert;
import org.junit.Test;

public class TestTrustAllManager {
  @Test
  public void testTrustAllManager() throws Exception {
    TrustAllManager manager = new TrustAllManager();
    manager.checkClientTrusted((X509Certificate[]) null, (String) null);
    manager.checkServerTrusted((X509Certificate[]) null, (String) null);

    manager.checkClientTrusted((X509Certificate[]) null,
        (String) null,
        (Socket) null);
    manager.checkClientTrusted((X509Certificate[]) null,
        (String) null,
        (SSLEngine) null);

    manager.checkServerTrusted((X509Certificate[]) null,
        (String) null,
        (Socket) null);
    manager.checkServerTrusted((X509Certificate[]) null,
        (String) null,
        (SSLEngine) null);
    Assert.assertEquals(manager.getAcceptedIssuers() == null, true);
  }
}