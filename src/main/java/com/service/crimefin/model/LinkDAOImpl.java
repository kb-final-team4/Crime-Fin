package com.service.crimefin.model.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.crimefin.domain.HistoryVO;
import com.service.crimefin.domain.PhishingInfoVO;
import com.service.crimefin.model.LinkDAO;

@Repository
public class LinkDAOImpl implements LinkDAO{

	@Autowired
	private SqlSession sqlSession;
	private static final String NS = "sql.crime-fin.mapper.";
	
	@Override
	public String findOldPhishingIdForLink(String memberId) {
		return sqlSession.selectOne(NS+"findOldPhishingIdForLink", memberId);
	}

	@Override
	public int insertPhishingInfoWithLink(PhishingInfoVO phishingInfoVO) {
		return sqlSession.insert(NS+"insertPhishingInfoWithLink", phishingInfoVO);
	}

	@Override
	public int insertHistoryWithLink(HistoryVO historyVO) {
		return sqlSession.insert(NS+"insertHistoryWithLink", historyVO);
	}

	@Override
	public int updatePhishingInfoWithLink(PhishingInfoVO phishingInfoVO) {
		return sqlSession.update(NS+"updatePhishingInfoWithLink", phishingInfoVO);
	}

}
