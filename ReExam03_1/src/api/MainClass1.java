package api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

public class MainClass1 {

	public static void main(String[] args) {
		
			try {
			
			String apiURL = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1154551000";
			
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-type", "application/xml");
			
			BufferedReader reader = null;
			if(con.getResponseCode() == 200) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			String line = null;
			StringBuilder sb = new StringBuilder();
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
			
			reader.close();
			con.disconnect();
			
			// 응답데이터 확인
			// System.out.println(sb.toString());
			
			// 응답데이터(XML)를 JSON데이터로 변환하기
			JSONObject obj = XML.toJSONObject(sb.toString());
			// System.out.println(obj);
			
			// pubDate 조회
			String pubDate = obj.getJSONObject("rss")
							.getJSONObject("channel")
							.getString("pubDate");
			// System.out.println(pubDate);
			
			// category 조회
			String category = obj.getJSONObject("rss")
							  .getJSONObject("channel")
							  .getJSONObject("item")
							  .getString("category");
			// System.out.println(category);
							
			// data 속성에 저장된 날씨 배열 가져오기
			JSONArray dataList = obj.getJSONObject("rss")
								.getJSONObject("channel")
								.getJSONObject("item")
								.getJSONObject("description")
								.getJSONObject("body")
								.getJSONArray("data");
			
			
			
			List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
			
			// 순회
			for(int i = 0; i < dataList.length(); i++) {
				JSONObject data = dataList.getJSONObject(i);
				int temp = data.getInt("temp");
				String wfKor = data.getString("wfKor");
				int hour = data.getInt("hour");
				
				Map<String, Object> weather = new HashMap<String, Object>();
				
				weather.put("온도", temp);
				weather.put("날씨", wfKor);
				weather.put("시간", hour);
				
				list.add(weather);
				
				}
			

			
			// 결과 파일 만들기
			BufferedWriter writer = new BufferedWriter(new FileWriter("weather.txt"));
			writer.write(pubDate + "\n");
			writer.write(category + "\n");
			for(int i = 0; i < list.size(); i++) {
				writer.write(list.get(i).toString() + "\n");
			}
			writer.close();
			
		} catch(Exception e) {
			e.printStackTrace();
			
		}

	}

}
