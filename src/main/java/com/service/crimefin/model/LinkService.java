package com.service.crimefin.model;

public interface LinkService {
	//동봉된 링크 검색하기 최종.docx와 링크 조회 api 최종.docx 참고
	void doLinkService(String newHistoryId, String newPhishingId, String memberId, String url);
}
