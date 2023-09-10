package com.service.crimefin.model;

import com.service.crimefin.domain.PhishingInfoVO;

public interface PhishingInfoDAO {
	int insertPhishingInfoWithLink(PhishingInfoVO phishingInfoVO);
	int updatePhishingInfoWithLink(PhishingInfoVO phishingInfoVO);
}
