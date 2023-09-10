package com.service.crimefin.model;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.crimefin.domain.PhishingInfoVO;
import com.service.crimefin.model.PhishingInfoDAO;

@Repository
public class PhishingInfoDAOImpl implements PhishingInfoDAO{
	@Autowired
	private SqlSession sqlSession;
	private static final String NS = "sql.crime-fin.mapper.";
	
	@Override
	public int insertPhishingInfoWithLink(PhishingInfoVO phishingInfoVO) {
		return sqlSession.insert(NS+"insertPhishingInfoWithLink", phishingInfoVO);
	}

	

	@Override
	public int updatePhishingInfoWithLink(PhishingInfoVO phishingInfoVO) {
		return sqlSession.update(NS+"updatePhishingInfoWithLink", phishingInfoVO);
	}
}
