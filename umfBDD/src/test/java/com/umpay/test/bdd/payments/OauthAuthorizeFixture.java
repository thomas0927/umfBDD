/*
 * file name   : OauthAuthorize.java 
 * <br>copyright   : Copyright (c) 2018
 * <br>description : TODO<何时使用>[注意][示例]
 * <br>modified    : 
 * @author      <a href="mailto:zhangming@umpay.com">Thomas Zhang</a>
 * @version     1.0
 * @date        2018年2月12日 上午10:47:19
 */ 

package com.umpay.test.bdd.payments;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.umf.base.ReqUMF;
import com.umf.base.rest.APIContext;
import com.umpay.test.bdd.BaseFixture;
import com.umpay.test.bdd.entity.AccessToken;
import com.umpay.test.bdd.entity.ConstantKey;

/*************************************************************************
 * description : TODO
 * @author      <a href="mailto:zhangming@umpay.com">Thomas Zhang</a>
 * @date        2018年2月12日 上午10:47:19
 * @version     1.0             
 *************************************************************************/
@RunWith(value = ConcordionRunner.class)
public class OauthAuthorizeFixture extends BaseFixture {

	private static final Logger logger = LoggerFactory.getLogger(OauthAuthorizeFixture.class);
	
	
	public AccessToken authorize(String uri,String clientSecret,String clientId){
		
		APIContext apiContext=new APIContext(); 
		String url = uri+ConstantKey.OauthUrl;
		apiContext.setOauthUrl(url);
		apiContext.setClientId(clientId);
		apiContext.setClientSecret(clientSecret);
		String result="";
		try {
			logger.info(String.format("apiContext oauthUrl:%s", apiContext.oauthUrl));
			result = ReqUMF.getOauth(apiContext);
			Gson gson=new Gson();
			AccessToken token= gson.fromJson(result, AccessToken.class);
			logger.info(String.format("apiContext token:%s and Expires time :%s", token.getToken(),(System.currentTimeMillis() + token.getExpiresIn()*1000)));
			return token;
		} catch (Exception e2) {
			logger.error(e2.getMessage());
		}
		return null;
	}
}
