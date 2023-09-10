package com.service.crimefin.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.crimefin.domain.HistoryVO;
import com.service.crimefin.domain.PhishingInfoVO;
import com.service.crimefin.model.HistoryDAO;
import com.service.crimefin.model.LinkService;
import com.service.crimefin.model.PhishingInfoDAO;

@Service
public class LinkServiceImpl implements LinkService{

	@Autowired
	private HistoryDAO historyDAO;
	@Autowired
	private PhishingInfoDAO phishingInfoDAO;
	
	//public PhishingInfoVO(newPhisingId, null, null, retrieved phishingLink)
	//public HistoryVO(newHistoryId, retrieved login - memberId, sysdate, that newPhishingId)
	@Override
	public void doLinkService(String newHistoryId, String newPhishingId, String memberId, String url) {
		String oldPhId = null;
		oldPhId = historyDAO.findOldPhishingIdForLink(memberId);
		
		//앞전 단계에서 번호 조회한적 없을때
		if(oldPhId==null) {
			
			//todo : 새 피싱info 아이디 명명패턴 구현하기 -> controller에서 해주기
			//String newPhishingId = "newPhishingId";
			PhishingInfoVO phishingInfoVO = new PhishingInfoVO(newPhishingId, null, null, url);
			phishingInfoDAO.insertPhishingInfoWithLink(phishingInfoVO);
			
			//todo : 새 히스토리 아이디 명명패턴 구현하기 -> controller에서 해주기
			//String newHistoryId = "newHistoryid";
			HistoryVO historyVO = new HistoryVO(newHistoryId, memberId, "sysdate", newPhishingId);
			historyDAO.insertHistoryWithLink(historyVO);
		}
		
		//앞전 단계에서 번호 조회 했을때 
		else {
			PhishingInfoVO phishingInfoVO = new PhishingInfoVO(oldPhId, null, null, url);
			phishingInfoDAO.updatePhishingInfoWithLink(phishingInfoVO);
		}
	}

}
