package com.service.crimefin.model;

import com.service.crimefin.domain.HistoryVO;
import com.service.crimefin.domain.PhishingInfoVO;

public interface LinkDAO {
	String findOldPhishingIdForLink(String memberId);
	int insertPhishingInfoWithLink(PhishingInfoVO phishingInfoVO);
	int insertHistoryWithLink(HistoryVO historyVO);
	int updatePhishingInfoWithLink(PhishingInfoVO phishingInfoVO);
}
