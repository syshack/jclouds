/**
 * Licensed to jclouds, Inc. (jclouds) under one or more
 * contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  jclouds licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jclouds.dynect.v3;

import static java.util.concurrent.TimeUnit.MINUTES;
import static org.jclouds.Constants.PROPERTY_TIMEOUTS_PREFIX;

import java.net.URI;
import java.util.Properties;

import org.jclouds.apis.ApiMetadata;
import org.jclouds.dynect.v3.config.DynECTParserModule;
import org.jclouds.dynect.v3.config.DynECTRestClientModule;
import org.jclouds.rest.RestContext;
import org.jclouds.rest.internal.BaseRestApiMetadata;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.TypeToken;
import com.google.inject.Module;

/**
 * Implementation of {@link ApiMetadata} for DynECT 1.0 API
 * 
 * @author Adrian Cole
 */
public class DynECTApiMetadata extends BaseRestApiMetadata {
   
   public static final String ANONYMOUS_IDENTITY = "ANONYMOUS";

   public static final TypeToken<RestContext<DynECTApi, DynECTAsyncApi>> CONTEXT_TOKEN = new TypeToken<RestContext<DynECTApi, DynECTAsyncApi>>() {
      private static final long serialVersionUID = 1L;
   };

   @Override
   public Builder toBuilder() {
      return new Builder().fromApiMetadata(this);
   }

   public DynECTApiMetadata() {
      this(new Builder());
   }

   protected DynECTApiMetadata(Builder builder) {
      super(builder);
   }

   public static Properties defaultProperties() {
      Properties properties = BaseRestApiMetadata.defaultProperties();
      properties.setProperty(PROPERTY_TIMEOUTS_PREFIX + "default", MINUTES.toMillis(3) + "");
      return properties;
   }

   public static class Builder extends BaseRestApiMetadata.Builder<Builder> {

      protected Builder() {
         super(DynECTApi.class, DynECTAsyncApi.class);
          id("dynect")
         .name("DynECT API2")
         .identityName("Username (or " + ANONYMOUS_IDENTITY + " if anonymous)")
         .defaultIdentity(ANONYMOUS_IDENTITY)
         .credentialName("Password")
         .defaultCredential(ANONYMOUS_IDENTITY)
         .documentation(URI.create("https://manage.dynect.net/help/docs/api2/rest/"))
         .version("3.3.7")
         .defaultEndpoint("https://api2.dynect.net/REST")
         .defaultProperties(DynECTApiMetadata.defaultProperties())
         .defaultModules(ImmutableSet.<Class<? extends Module>>builder()
                                     .add(DynECTParserModule.class)
                                     .add(DynECTRestClientModule.class).build());
      }
      
      @Override
      public DynECTApiMetadata build() {
         return new DynECTApiMetadata(this);
      }

      @Override
      protected Builder self() {
         return this;
      }
   }
}
