package org.jclouds.oauth.v2.config;

import static org.jclouds.reflect.Reflection2.typeToken;

import java.net.URI;

import javax.inject.Singleton;

import org.jclouds.oauth.v2.OAuthApi;
import org.jclouds.oauth.v2.OAuthAsyncApi;
import org.jclouds.providers.ProviderMetadata;
import org.jclouds.rest.ConfiguresRestClient;
import org.jclouds.rest.config.RestClientModule;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.inject.Provides;

/**
 * OAuth module to when accessing OAuth stand-alone.
 *
 * @author David Alves
 */
@ConfiguresRestClient
public class OAuthRestClientModule extends RestClientModule<OAuthApi, OAuthAsyncApi> {

   public OAuthRestClientModule() {
      super(typeToken(OAuthApi.class), typeToken(OAuthAsyncApi.class));
   }

   @Provides
   @Singleton
   @Authentication
   protected Supplier<URI> provideAuthenticationEndpoint(ProviderMetadata providerMetadata) {
      return Suppliers.ofInstance(URI.create(providerMetadata.getEndpoint()));
   }

}
