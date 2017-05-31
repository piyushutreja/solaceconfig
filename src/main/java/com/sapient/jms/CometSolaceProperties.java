/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
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

package com.sapient.jms;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("comet.solace")
public class CometSolaceProperties {

	private int sessionSize;
	private String fallbackURL;
	private String trustStore;
	private String trustStoreFormat;
	private String securityPrincipal;
	private String vpn;
	private String providerURL;
	private String contextFactory;
	private String credential;
	private String storePasssword;
	private String jndiName;
	private String defaultDestination;

	public String getDefaultDestination() {
		return defaultDestination;
	}

	public void setDefaultDestination(String defaultDestination) {
		this.defaultDestination = defaultDestination;
	}

	public String getJndiName() {
		return jndiName;
	}

	public void setJndiName(String jndiName) {
		this.jndiName = jndiName;
	}

	public String getStorePasssword() {
		return storePasssword;
	}

	public void setStorePasssword(String storePasssword) {
		this.storePasssword = storePasssword;
	}

	public String getCredential() {
		return credential;
	}

	public void setCredential(String credential) {
		this.credential = credential;
	}

	public int getSessionSize() {
		return sessionSize;
	}

	public void setSessionSize(int sessionSize) {
		this.sessionSize = sessionSize;
	}

	public String getFallbackURL() {
		return fallbackURL;
	}

	public void setFallbackURL(String fallbackURL) {
		this.fallbackURL = fallbackURL;
	}

	public String getTrustStore() {
		return trustStore;
	}

	public void setTrustStore(String trustStore) {
		this.trustStore = trustStore;
	}

	public String getTrustStoreFormat() {
		return trustStoreFormat;
	}

	public void setTrustStoreFormat(String trustStoreFormat) {
		this.trustStoreFormat = trustStoreFormat;
	}

	public String getSecurityPrincipal() {
		return securityPrincipal;
	}

	public void setSecurityPrincipal(String securityPrincipal) {
		this.securityPrincipal = securityPrincipal;
	}

	public String getVpn() {
		return vpn;
	}

	public void setVpn(String vpn) {
		this.vpn = vpn;
	}

	public String getProviderURL() {
		return providerURL;
	}

	public void setProviderURL(String providerURL) {
		this.providerURL = providerURL;
	}

	public String getContextFactory() {
		return contextFactory;
	}

	public void setContextFactory(String contextFactory) {
		this.contextFactory = contextFactory;
	}

}