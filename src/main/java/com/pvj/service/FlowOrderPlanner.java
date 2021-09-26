package com.pvj.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pvj.constants.HTTPStatusCode;
import com.pvj.exception.GlobalResponseException;
import com.pvj.util.FlowPlannerUtil;

@Service
public class FlowOrderPlanner {
	
	@Autowired
	private FlowPlannerUtil flowPlannerUtil;

	public void pushNotification() throws IOException, GlobalResponseException {
		List<String> fcmToken = flowPlannerUtil.getShopListFCMToken();
		final String POST_PARAMS = "{\"registration_ids\":"+fcmToken+",\"notification\":\"{\",\"body\":\"Body : Notification\",\"title\":\"Title : Notification\",\"image\":\"https://www.learndash.com/wp-content/uploads/Notification-Add-on.png\"\"}\"}";
		System.out.println(POST_PARAMS);
		URL obj = new URL(HTTPStatusCode.NOTIFICATION_URL);
		HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
		postConnection.setRequestMethod("POST");
		postConnection.setRequestProperty(HTTPStatusCode.AUTHORIZATIOIN, HTTPStatusCode.FCM_AUTHORIZATIOIN);
		postConnection.setRequestProperty("Content-Type", "application/json");

		postConnection.setDoOutput(true);
		OutputStream os = postConnection.getOutputStream();
		os.write(POST_PARAMS.getBytes());
		os.flush();
		os.close();

		int responseCode = postConnection.getResponseCode();
		System.out.println("POST Response Code :  " + responseCode);
		System.out.println("POST Response Message : " + postConnection.getResponseMessage());

		if (responseCode == HttpURLConnection.HTTP_CREATED) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(postConnection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println(response.toString());
		} else {
			System.out.println("POST NOT WORKED");
		}
	}

}
