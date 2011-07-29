/**
 *
 * Copyright (C) 2011 Cloud Conscious, LLC. <info@cloudconscious.com>
 *
 * ====================================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ====================================================================
 */
package org.jclouds.trmk.vcloud_0_8.domain;


/**
 * 
 * A network that is available in a vDC.
 * 
 * @author Adrian Cole
 */
public interface Network extends ReferenceType {
   /**
    * 
    * @return Description of the network
    */
   String getDescription();

   /**
    * 
    * 
    * @return The IP address of the network primary gateway
    */
   String getGateway();

   /**
    * *
    * 
    * @return the network subnet mask
    */
   String getNetmask();

   /**
    * return the network fence mode.
    */
   FenceMode getFenceMode();

   ReferenceType getNetworkExtension();

   ReferenceType getIps();
}