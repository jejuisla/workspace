package edu.kh.openapi.controller;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class TestController {

	private final String serviceKey = "xjr91ulq%2Fm7d%2FLwUWEkDAKl7Bo5OdLa7q9Db1PVhqH3%2FLFLxcFamNlIVQIf1QXAhFda32vIxn0abtP%2BdC%2B4PMQ%3D%3D";

	/** 에어코리아 대기오염정보 - 시도별 실시간 측정정보 조회

	* @param location : 지역명(시, 도 이름)

	* @throws IOException

	*/

	@GetMapping("air")

	public String airPollution(@RequestParam("location") String location) throws IOException{

	String requestUrl = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";

	StringBuilder urlBuilder = new StringBuilder(requestUrl);
	urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + serviceKey); /*Service Key*/
	urlBuilder.append("&" + URLEncoder.encode("sidoName","UTF-8") + "=" + URLEncoder.encode(location, "UTF-8"));

	urlBuilder.append("&" + URLEncoder.encode("returnType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8"));


	// 공공데이터 요청 및 응답

	URL url = new URL(urlBuilder.toString());

	HttpURLConnection conn = (HttpURLConnection) url.openConnection();

	conn.setRequestMethod("GET");

	conn.setRequestProperty("Content-type", "application/json");

	BufferedReader rd;

	if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {

	rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

	} else {

	rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));

	}

	StringBuilder sb = new StringBuilder();

	String line;

	while ((line = rd.readLine()) != null) {

	sb.append(line);

	}

	rd.close();

	conn.disconnect();

	//

	log.debug(sb.toString());

	return "air";

	}
}
