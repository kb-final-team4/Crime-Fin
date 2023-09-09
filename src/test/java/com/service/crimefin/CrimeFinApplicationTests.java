package com.service.spring;

import com.service.crimefin.domain.HistoryVO;
import com.service.crimefin.domain.MemberVO;
import com.service.crimefin.domain.PhishingInfoVO;
import com.service.crimefin.model.MemberDAO;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.Reader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Set;

@SpringBootTest
@Transactional
@Commit
public class CrimeFinApplicationTests {
	public static final String NS = "sql.crime-fin.mapper.";
		//   @Autowired
		//   private static MemberDAO memberDAO;
		//
		//    @Test
		//	public void unit() throws Exception{
		
	public static void main(String[ ] args) throws Exception{
		
		Reader r=Resources.getResourceAsReader("config/SqlMapConfig.xml");
		System.out.println("1....");
		//1. SqlSessionFactory -- SqlSessionFactoryBean
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		System.out.println("2....");
		//2. SqlSession -- SqlSessionTemplate
		SqlSession ssession=factory.openSession();
		System.out.println("3....");
		//3.  System.out.println("1...."); 쿼리문 실행
		
		//링크 테스트 시나리오
		//멤버 test2는 메신저 피싱을 의심하고 있다.
		//"jov.kr" 링크를 받았다. 카톡으로 와서 번호 모른다.
		String memberId = "test2";
		String testurl = "jov.kr";
		String rst = null;
		rst = (String) ssession.selectOne(NS+"findOldPhishingIdForLink", memberId);
		if(rst == null) {
			System.out.println("번호를 모르는군요!");
			String newPhishingId = "newPIdtest2";
			PhishingInfoVO phishingInfoVO = new PhishingInfoVO(newPhishingId, null, null, testurl);
			ssession.insert(NS+"insertPhishingInfoWithLink", phishingInfoVO);
			ssession.commit();
			System.out.println("새 피싱 정보 입력 완");
			
			String newHistoryId = "newHidtest2";
			HistoryVO historyVO = new HistoryVO(newHistoryId, memberId, null, newPhishingId);
			ssession.insert(NS+"insertHistoryWithLink", historyVO);
			ssession.commit();
			System.out.println("새 히스토리 입력 완");
		}
		else {
			System.out.println("번호를 알긴 하는군요!");
			PhishingInfoVO phishingInfoVO = new PhishingInfoVO(rst, null, null, testurl);
			ssession.update(NS+"updatePhishingInfoWithLink", phishingInfoVO);
			ssession.commit();
			System.out.println("기존 피싱 정보 업데이트 완");
		}
		
		
		
		
		
		/*
		 *  자바 11로 올려야됨 
		 *  
		 *  <!-- JSON-simple 라이브러리 -->
			<dependency>
		    	<groupId>com.googlecode.json-simple</groupId>
		    	<artifactId>json-simple</artifactId>
		    	<version>1.1.1</version>
			</dependency>
		 *  
		 *  
		 	import java.net.URI;
			import java.net.http.HttpClient;
			import java.net.http.HttpRequest;
			import java.net.http.HttpResponse;
			import java.util.Base64;
		  
			import org.json.simple.JSONObject;
			import org.json.simple.parser.JSONParser;
			
		 */
		
		
		//////////////////////////////////////////////////////////////////////////////////////
		//Controller에 들어갈 VirusTotal 관련 메서드 뼈대
		//이름은..public String checkLinkIsSpam(HttpSession session, String inputUrl)
		
		//String memberId = session.getAttribute("memberId");
		//String url = inputUrl;
		//String url = "ca01.kro.kr";
		//String url = "jov.kr";
		String url = "pf.kakao.com/_xjWlxmC/97724667";
		String path = "링크검사하는페이지";
		
		String encodedURl = Base64.getEncoder().withoutPadding().encodeToString(url.getBytes()); 
		//System.out.println("encoded string : "+ encodedURl);

		HttpRequest request = HttpRequest.newBuilder()
			    .uri(URI.create("https://www.virustotal.com/api/v3/urls/"+encodedURl))
			    .header("accept", "application/json")
			    .header("x-apikey", "2d51d2d86c432e6826f2f8110b9b932042791e63c6a85a627ff9a90f057e4e28")
			    .method("GET", HttpRequest.BodyPublishers.noBody())
			    .build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		//System.out.println(response.body());
		
		String vtResultStr = response.body();
		
		JSONParser parser = new JSONParser();
		Object vtResultObj = parser.parse(vtResultStr); 
		 
		JSONObject vtResult = (JSONObject) vtResultObj;
		JSONObject vtResultData = (JSONObject) vtResult.get("data");
		
		JSONObject vtResultAttributes = null;
		try {
			vtResultAttributes = (JSONObject) vtResultData.get("attributes");
		} catch (Exception e) {
			//백신들이 탐지 못하는 링크임. 없어진 링크나 잘못된 입력임
			//다음 페이지로 가는 path 리턴하기
			System.out.println("This link is unavailable, let's try our AI analysis.");
			return;
		}
		JSONObject vtResultLastAnalysisResults = null;
		
		try {
			vtResultLastAnalysisResults = (JSONObject) vtResultAttributes.get("last_analysis_results");
		}catch (Exception e) {
			//백신들이 탐지 못하는 링크임. 없어진 링크나 잘못된 입력임
			//다음 페이지로 가는 path 리턴하기
			System.out.println("This link is unavailable, let's try our AI analysis.");
			return;
		}
		
		
		//System.out.println(vtResultSeclookup.get("category"));
		Set vaccineSet = vtResultLastAnalysisResults.keySet();
		ArrayList<Integer> isSpamList = new ArrayList<Integer>();
		
		for(Object s : vaccineSet) {
			JSONObject vtResultVaccine = (JSONObject) vtResultLastAnalysisResults.get((String) s);
				if(((String) vtResultVaccine.get("category")).equals("malicious")) {
					isSpamList.add(1);
				}
			else {
				isSpamList.add(0);
			}
		}
		 
		for(int i : isSpamList) {
			if((i&1)==1) {
				System.out.println("This link is SPAM!!!!");
				return;
				//스팸일때 이 링크 저장하는 쿼리문 들어있는 서비스DAO의 적절한 메서드 호출하기
				//serviceDAO.doLinkService(newHistoryId, newPhishingId, memberId, url);
				//path = "링크스팸이니까결과페이지path";
				//return path;
				
			}
		}
		System.out.println("This link is undetected. But you can try out our AI analysis for this link.");
		//다음 페이지로 가는 path 리턴하기
		//return path;
		
		
		
	}//main 
     
}
