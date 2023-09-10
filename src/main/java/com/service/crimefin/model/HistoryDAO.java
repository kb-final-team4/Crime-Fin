package com.service.crimefin.model;

import com.service.crimefin.domain.HistoryVO;

public interface HistoryDAO {
	String findOldPhishingIdForLink(String memberId);
	int insertHistoryWithLink(HistoryVO historyVO);
}
