package com.umpay.test.bdd.entity;

import com.umf.api.payments.Meta;

public class AccessToken {
	private String token;
	// remain time in seconds since acquiring.
	private long expiresIn;
	
	private Meta meta;
	
	// unix time of acquire access token in second. 
	private long acquireTime;
	
	/**
	 * @return the meta
	 */
	public Meta getMeta() {
		return meta;
	}
	/**
	 * @param meta the meta to set
	 */
	public void setMeta(Meta meta) {
		this.meta = meta;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public long getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(long expiresIn) {
		this.expiresIn = expiresIn;
	}
	
	public boolean isExpired(){
		return false;
	}
}
