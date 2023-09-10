package com.service.crimefin.model;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.crimefin.domain.HistoryVO;
import com.service.crimefin.model.HistoryDAO;

@Repository
public class HistoryDAOImpl implements HistoryDAO{

	@Autowired
	private SqlSession sqlSession;
	private static final String NS = "sql.crime-fin.mapper.";
	
	@Override
	public String findOldPhishingIdForLink(String memberId) {
		return sqlSession.selectOne(NS+"findOldPhishingIdForLink", memberId);
	}

	@Override
	public int insertHistoryWithLink(HistoryVO historyVO) {
		return sqlSession.insert(NS+"insertHistoryWithLink", historyVO);
	}

}
