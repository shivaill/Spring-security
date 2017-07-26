package com.objectfrontier.ecapp.security.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

public class AuthenticationUtil {
 
	public static Integer postAuthentication(String targetURL, String userName, String password) 
			throws ClientProtocolException, IOException {
		
		Integer reponseCode = null;
		HttpClient httpclient = HttpClients.createDefault();
		HttpPost httppost = new HttpPost(targetURL);
	
		// Request parameters and other properties.
		List<NameValuePair> params = new ArrayList<NameValuePair>(2);
		params.add(new BasicNameValuePair("userName", userName));
		params.add(new BasicNameValuePair("password", password));
		httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

		//Execute and get the response.
		HttpResponse response = httpclient.execute(httppost);
		HttpEntity entity = response.getEntity();
		if (!Objects.isNull(entity) && !Objects.isNull(response.getStatusLine()) && !(response.getStatusLine().getStatusCode() == 600)) {
			reponseCode = response.getStatusLine().getStatusCode();
		}
		return reponseCode;
	}
}
