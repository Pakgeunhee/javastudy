package api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class ApiMain {

	public static void main(String[] args) {
		
		try {
			// API주소
			String apiURL = "http://apis.data.go.kr/B552061/AccidentDeath/getRestTrafficAccidentDeath";			
			apiURL += "?serviceKey=" + URLEncoder.encode("n0aKPJ6xVZKaxtVsqCYDsJ0fLIbVEb8HTpItw9e2qK4aZaXyma4XkCn6Kh7H4MBiopv31ULTJKUGssagwo5skQ==", "UTF-8");
			apiURL += "&searchYear=" + URLEncoder.encode("2021", "UTF-8");
			apiURL += "&siDo=" + URLEncoder.encode("1100", "UTF-8");
			apiURL += "&guGun=" + URLEncoder.encode("1125", "UTF-8");
			apiURL += "&type=" + URLEncoder.encode("json", "UTF-8");
			apiURL += "&numOfRows=" + URLEncoder.encode("10", "UTF-8");
			apiURL += "&pageNo=" + URLEncoder.encode("1", "UTF-8");

			// URL 객체 생성(API주소의 형식 검증)
			URL url = new URL(apiURL);
			
			// API주소 접속
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			
			
			// GET 방식의 요청임을 처리 (GET방식 : 주소창에 주렁주렁 매달아서 요청하는 방식)
			con.setRequestMethod("GET");
			
			// 응답 데이터는 "json"임을 처리
			// 웹 상에서 주고 받는 데이터의 타입 : Content-Type
			// 받아온 자료가 UTF-8에 해당되는 자료가 없어서 charset=UTF-8 생략
			con.setRequestProperty("Content-Type", "application/json");
			
			// 접속된 API로부터 데이터를 읽어 들일 입력 스트림 생성
			// 1. 정상 스트림과 에러 스트림으로 구분해서 생성
			// 2. API 입력 스트림은 오직 바이트 입력 스트림만 지원하므로 문자 입력 스트림으로 바꾸는 작업이 필요하다.
			// 3. 속도 향상을 위해서 Buffer가 내장된 스트림을 생성			
			BufferedReader reader = null;
			if((con.getResponseCode() == 200)) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			// BufferedReader는 readLine 메소드를 지원한다.
			String line = null;
			StringBuilder sb = new StringBuilder();
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
			
			// 이제 API의 응답 데이터는 sb에 저장되어 있다.
			// System.out.println(sb.toString());
			
			// API의 응답 데이터를 분석하기 위해서 JSONObject로 변환한다.
			// json 라이브러리 사용을 위해서 Build Path 작업을 수행한다.
			/* 방법1
			JSONObject obj = new JSONObject(sb.toString());
			JSONObject items = obj.getJSONObject("items");
			JSONArray itemList = items.getJSONArray("item");
			*/			
			JSONArray itemList = new JSONObject(sb.toString())
								.getJSONObject("items")
								.getJSONArray("item");
			
			// 4개의 정보를 하나의 데이터로 만들기 위해서는? (1건의 사고정보)
			// 1. Bean 생성 -> 이 방법으로 처리 진행 (accident 1개가 4개의 자료를 다 가지게 됨)
			// 2. Map 생성
			StringBuilder fileBuilder = new StringBuilder();
			List<Accident> list = new ArrayList<Accident>();
			
			for(int i = 0; i < itemList.length(); i++) {
				// 응답 데이터에서 필요한 데이터를 분석(파싱)한다.
				JSONObject item = itemList.getJSONObject(i);
				String occrrncDt = item.getString("occrrnc_dt");
				String[] week = {"", "일", "월", "화", "수", "목", "금", "토"};
				String occrrncDayCd = item.getString("occrrnc_day_cd");
				int dthDnvCnt = item.getInt("dth_dnv_cnt");
				int injpsnCnt = item.getInt("injpsn_cnt");
				fileBuilder.append("발생일자 ").append(occrrncDt).append(" ").append(week[Integer.parseInt(item.getString("occrrnc_day_cd"))]).append("요일, ");
				fileBuilder.append("사망자수 ").append(dthDnvCnt).append("명, ");
				fileBuilder.append("부상자수 ").append(injpsnCnt).append("명\n");
				
				// 응답 데이터에서 추출한 데이터를 하나의 객체(Bean)로 만든다.
				Accident accident= new Accident();
				accident.setOccrrncDt(occrrncDt);
				accident.setOccrrncDayCd(occrrncDayCd);
				accident.setDthDnvCnt(dthDnvCnt);
				accident.setInjpsnCnt(injpsnCnt);
				
				// 객체를 ArrayList에 저장한다.
				list.add(accident);
			}
			
			
			File file = new File("accident.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(fileBuilder.toString());
			writer.flush();
			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}				
	}
}
