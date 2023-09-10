package com.service.crimefin.model;

import com.service.crimefin.domain.MemberVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberDAOImpl implements MemberDAO {

    @Autowired
    private SqlSession sqlSession;

    public static final String NS = "sql.crime-fin.mapper.";

    @Override
    public MemberVO login(MemberVO memberVO) {
        return sqlSession.selectOne(NS+"selectMember", memberVO);
    }

    @Override
    public int updateMemberInfo(MemberVO memberVO) {
        return sqlSession.update(NS+"updateMember", memberVO);
    }

    @Override
    public int insertMember(MemberVO memberVO) {
        return sqlSession.insert(NS+"insertMember", memberVO);
    }

    @Override
    public int deleteMember(MemberVO memberVO) {
        return sqlSession.delete(NS+"deleteMember", memberVO);
    }

    @Override
    public String selectMemberId(MemberVO memberVO) {
        return sqlSession.selectOne(NS+"selectMemberId", memberVO);
    }

    @Override
    public int isExistMemberId(String memberId) {
        return sqlSession.selectOne(NS+"isExistMemberId", memberId);
    }

    @Override
    public int isExistMemberEmail(String email) {
        return sqlSession.selectOne(NS+"isExistMemberEmail", email);
    }

    @Override
    public String selectAddress(String memberId) {
        return sqlSession.selectOne(NS+"selectAddress", memberId);
    }
}
